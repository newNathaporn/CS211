
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FileInfoFrame2 extends JFrame {
    JTextArea area;
    JScrollPane scp;
    JTextField name;
    JButton findBtn;
    JButton chooseBtn;
    JFileChooser chooser;
    public FileInfoFrame2(){
        area = new JTextArea(10,40);
        scp = new JScrollPane(area);
        this.add(scp, BorderLayout.CENTER);
        name = new JTextField (20);
        name.setEditable(false);
        chooseBtn = new JButton ("...");
        chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooseBtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                name.setText("");
                chooser.setSelectedFile(new File(""));
                int option = chooser.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    name.setText(chooser.getSelectedFile().getAbsolutePath());
                }
            }
            
        });
        findBtn = new JButton ("Find");
        findBtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                getFileInfo(name.getText());
            }
            
        });
        JPanel panel = new JPanel();
        panel.add(name);
        panel.add(chooseBtn);
        panel.add(findBtn);
        this.add(panel, BorderLayout.NORTH);
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void getFileInfo(String fname){
        area.setText("");
        File file = new File(fname);
        if (!file.exists()){
           area.append("The file does not exist") ;
           return;
        }
        
        //If file exists, check if it is a file or directory
        area.append("Path is: " + file.getPath() + "\n");
        area.append("Absolute Path is: " + file.getAbsolutePath() + "\n");
        area.append("Name is: " + file.getName() + "\n");
        
        if (file.isDirectory()){
            area.append("Children of this directory are: \n"); 
            for (File child: file.listFiles()){
                if (child.isDirectory()){
                    area.append("[" + child.getName().toUpperCase()  + "] \n"); 
                }else{
                    area.append(child.getName() + "\n"); 
                }
            }
        }
        
    }
    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        FileInfoFrame2 fi = new FileInfoFrame2();
    }

}
