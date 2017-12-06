

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemberFrame extends JFrame {
    JLabel infoLbl;    JScrollPane scp;  JTextField name;  JButton findBtn;
    MemberReader mReader;
    public MemberFrame(){
        infoLbl = new JLabel("");
        infoLbl.setVerticalAlignment(JLabel.TOP);
        scp = new JScrollPane(infoLbl);
        this.add(scp, BorderLayout.CENTER);
        name = new JTextField (20);
        findBtn = new JButton ("Load");
        mReader = new MemberReader();
        findBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    mReader.loadMember(new File (name.getText()));
                    infoLbl.setText(mReader.toString());
                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "Selected file cannot be found", "Error", JOptionPane.INFORMATION_MESSAGE);
                }               
            }          
        });
        JPanel panel = new JPanel();
        panel.add(name);
        panel.add(findBtn);
        this.add(panel, BorderLayout.NORTH);
        setVisible(true);
        this.setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        MemberFrame fi = new MemberFrame();
    }

}
