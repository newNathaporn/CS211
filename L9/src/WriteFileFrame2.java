

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WriteFileFrame2 extends JFrame {
    JTextArea area;
    JScrollPane scp;
    JButton saveBtn;
    JFileChooser chooser;
    public WriteFileFrame2(){
        area = new JTextArea(10,40);
        scp = new JScrollPane(area);
        this.add(scp, BorderLayout.CENTER);
        chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        saveBtn = new JButton ("Save");
        saveBtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                chooser.setSelectedFile(new File(""));
                int option = chooser.showSaveDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File f = chooser.getSelectedFile();
                    saveFile(f);
                }
            }          
        });
        this.add(saveBtn, BorderLayout.SOUTH);
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void saveFile(File f){

        FileWriter fWriter = null;
        PrintWriter out = null;
        try {
        
            fWriter = new FileWriter(f,f.exists());
            out = new PrintWriter(fWriter);
            String ln = System.getProperty("line.separator");
            out.print(area.getText().replaceAll("\n", ln));
            out.close();
        } catch (IOException e) {
            System.out.println("Error: Can't write to file");
            return;
        }        
    }
    public static void main(String[] args) {

        WriteFileFrame2 fi = new WriteFileFrame2();
    }
}
