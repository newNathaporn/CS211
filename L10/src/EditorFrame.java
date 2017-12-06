import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class EditorFrame extends JFrame {
    private RABinaryFile msgFile;
    private File file;
    private TextPanel txtArea;
    JFileChooser chooser;

    public EditorFrame() {
        msgFile = new RABinaryFile();
        chooser = new JFileChooser("./");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        txtArea = new TextPanel("untitled file");

        add(txtArea);
        createMenu();
        
        setTitle("Simple Editor");
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menufile = new JMenu("File");
        JMenuItem newMenu = new JMenuItem("New");
        JMenuItem openMenu = new JMenuItem("Open");
        JMenuItem insertMenu = new JMenuItem("Insert from file");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem saveAs = new JMenuItem("Save As");
        setJMenuBar(menuBar);
        menuBar.add(menufile);
        menufile.add(newMenu);
        menufile.add(openMenu);
        menufile.add(insertMenu);
        menufile.add(save);
        menufile.add(saveAs);
        
        openMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    file = chooser.getSelectedFile();
                    msgFile.setFile(file);
                    try {
                        txtArea.setText(msgFile.readRawFile());
                        txtArea.setTitle(file.getName());
                    } catch (IOException e) {
                        System.out.println(e);
                        ;
                    }
                }
            }

        });

        newMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                txtArea.setText("");
                txtArea.setTitle("untitled file");
                file = null;
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if (file == null) {
                    if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                        file = chooser.getSelectedFile();
                    } else
                        return;
                }
                saveFile();
            }
        });
        
        saveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    file = chooser.getSelectedFile();
                    saveFile();
                }
            }
        });

        insertMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (file != null) {
                    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        File tempFile = chooser.getSelectedFile();
                        try {
                            // save the exist file first
                            msgFile.writeMessage(txtArea.getText());
                            // ask for the position to insert
                            int start = Integer.valueOf(JOptionPane.showInputDialog("Enter the position (0-"+file.length()+")"));
                            // insert the 2nd file to the 1st file at the specific position 
                            txtArea.setText(msgFile.insertMessage(start, tempFile));
                        } catch (FileNotFoundException | IllegalArgumentException e) {
                            System.out.println(e);
                        } catch (IOException e) {
                            System.out.println(e);
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Open one file first and then insert another one to the open file");
                }
            }
        });
    }

    private void saveFile() {
        try {
            msgFile.setFile(file);
            msgFile.writeMessage(txtArea.getText());
            txtArea.setTitle(file.getName());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new EditorFrame();
    }

}
