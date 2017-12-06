import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class TextPanel extends JPanel {
    private JTextArea txtArea;
    private JScrollPane scPane;
    private TitledBorder titleBorder;
    
    public TextPanel(String title) {
        titleBorder = new TitledBorder(title);
        setLayout(new BorderLayout());
        Font font = new Font("Tahoma", Font.PLAIN, 20);
        txtArea = new JTextArea(10, 20);
        txtArea.setFont(font);
        txtArea.setLineWrap(true);        
        scPane = new JScrollPane(txtArea);
        scPane.setBorder(titleBorder);
        add(scPane, BorderLayout.CENTER);
    }
    
    public String getTitle() {
        return titleBorder.getTitle();
    }

    public void setTitle(String title) {
        titleBorder.setTitle(title);
        repaint();
    }

    public String getText() {
        return txtArea.getText();
    }
    
    public void setText(String str) {
        txtArea.setText(str);
    }
    
    public void appendText(String str) {
        txtArea.append(str);
    }
    
    public void setEditable(boolean editable) {
        txtArea.setEditable(editable);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel[] panels = new JPanel[4];
        for (int i=0; i<panels.length; i++) {
            panels[i] = new JPanel();
            panels[i].setPreferredSize(new Dimension(20, 20));
        }
        frame.add(panels[0], BorderLayout.NORTH);
        frame.add(panels[1], BorderLayout.SOUTH);
        frame.add(panels[2], BorderLayout.EAST);
        frame.add(panels[3], BorderLayout.WEST);
        frame.add(new TextPanel("Plain Text"));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
