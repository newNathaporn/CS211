import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DayOfWeekFrame extends JFrame implements ActionListener {

    private JLabel label;
    private JComboBox<DayOfWeek> list;

    public DayOfWeekFrame() {
        list = new JComboBox<DayOfWeek>(DayOfWeek.values());
        list.addActionListener(this);

        setLayout(new GridLayout(0, 1));

        JPanel panel = new JPanel();
        panel.add(list);
        add(panel);

        label = new JLabel(DayOfWeek.MONDAY + " is "
                + getLatinName(DayOfWeek.MONDAY));
        label.setFont(new Font("Consolas", Font.PLAIN, 20));
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);

        setTitle("Latin name of day");
        setSize(400, 160);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public String getLatinName(DayOfWeek day) {
        switch (day) {
        case MONDAY:    return "Lunae - Moon";
        case TUESDAY:   return "Martis - Mars";
        case WEDNESDAY: return "Mercurii - Mercury";
        case THURSDAY:  return "Jovis - Jupiter";
        case FRIDAY:    return "Veneris - Venus";
        case SATURDAY:  return "Saturni - Saturn";
        case SUNDAY: 
        default:        return "Solis - Sun";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DayOfWeek day =(DayOfWeek) list.getSelectedItem();
        label.setText(day + " is " + getLatinName(day));
    }

    public static void main(String[] args) {
        new DayOfWeekFrame();
    }
}