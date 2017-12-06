package ver2;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DayOfWeekFrame2 extends JFrame implements ActionListener {
    private JLabel label;
    private JComboBox<DayOfWeek2> list;

    public DayOfWeekFrame2() {
        list = new JComboBox<>(DayOfWeek2.values());
        list.addActionListener(this);

        setLayout(new GridLayout(0, 1));

        JPanel panel = new JPanel();
        panel.add(list);
        add(panel);

        label = new JLabel(DayOfWeek2.MONDAY + " is "
                + DayOfWeek2.MONDAY.getLatinName());
        label.setFont(new Font("Consolas", Font.PLAIN, 20));
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);

        setTitle("Latin name of day");
        setSize(400, 160);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        DayOfWeek2 day = (DayOfWeek2) list.getSelectedItem();
        label.setText(day + " is " + day.getLatinName());
    }

    public static void main(String[] args) {
        new DayOfWeekFrame2();
    }
}