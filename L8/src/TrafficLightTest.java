import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrafficLightTest extends JFrame {
    private JPanel light;
    private TrafficLight on;
    private JButton nextBtn;

    public TrafficLightTest() {
        on = TrafficLight.RED;

        light = new JPanel();
        light.setBackground(on.getColor());
        add(light, BorderLayout.CENTER);

        nextBtn = new JButton("next");
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNext();

            }
        });
        add(nextBtn, BorderLayout.SOUTH);
        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setNext() {
        on = on.next();
        light.setBackground(on.getColor());
        repaint();
    }

    public static void main(String[] args) {
        new TrafficLightTest();
    }
}