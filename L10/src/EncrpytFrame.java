import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class EncrpytFrame extends JFrame {
    private Encryptor encData;
    private TextPanel txtArea, encArea;
    private JTextField keyField, inFileField, outFileField;
    private JButton txtBtn;
    
    public EncrpytFrame() {
        encData = new Encryptor(0);

        // create textPanel for original text and encrypt text
        txtArea = new TextPanel("Plain Text");
        //txtArea.setEditable(false);
        encArea = new TextPanel("Encrypt Text");
        encArea.setEditable(false);
        
        // create 3 textfields for 3 inputs 
        inFileField = new JTextField(10);
        inFileField.setBorder(new TitledBorder("Original File"));
        outFileField = new JTextField(10);
        outFileField.setBorder(new TitledBorder("Encrypt File"));
        keyField = new JTextField(10);
        keyField.setText("0");
        keyField.setBorder(new TitledBorder("Key code"));

        txtBtn = new JButton("Encrypt");
        txtBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                File inFile = new File(inFileField.getText());
                File outFile = new File(outFileField.getText());
                encData.setKey(Integer.valueOf(keyField.getText()));
                try {
                    encData.encryptStream(inFile, outFile);
                    txtArea.setText(encData.readRawFile(inFile));
                    encArea.setText(encData.readRawFile(outFile));
                } catch (IOException e) {
                    System.out.println(e); 
                }
            }
        });

        JPanel northPanel = new JPanel();
        northPanel.add(inFileField);
        northPanel.add(outFileField);
        northPanel.add(keyField);
        northPanel.add(txtBtn);
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(1, 2));
        gridPanel.add(txtArea);
        gridPanel.add(encArea);
        
        add(gridPanel, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);
        
        setTitle("Encrypt Frame");
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new EncrpytFrame();
    }
}
