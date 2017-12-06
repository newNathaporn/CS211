
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class QueueFrame extends JFrame{

    JTextArea orderArea;
    String menu[] = {"IceCream", "Pizza", "Salad", "Tea", "Coffee"};
    JButton addOrder,serviceOrder;
    JLabel serviceLabel;
    LinkedList<String> orderList;
    
    public QueueFrame (){
        orderList = new LinkedList<String>();
        createFrame();      
        addOrder.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                addOrder();
            }});
        serviceOrder.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                service();
            }});
     }
    private void createFrame(){
        orderArea = new JTextArea();
        orderArea.setEditable(false);
        JScrollPane pane = new JScrollPane(orderArea);
        this.add(pane);
        
        JPanel bPanel = new JPanel();
        addOrder = new JButton("New Order");
        serviceOrder = new JButton ("Service Order");
        bPanel.add(addOrder);
        bPanel.add(serviceOrder);
        serviceLabel = new JLabel(" ");
        this.add(serviceLabel,BorderLayout.NORTH);
        this.add(bPanel, BorderLayout.SOUTH);
    }
    private void showOrder(){
        StringBuffer sb = new StringBuffer();
        for (String s: orderList){
            sb.append(s + "\n");
        }
        this.orderArea.setText(sb.toString());
    }
    private void addOrder(){
        Random ran = new Random();
        int ranNo = ran.nextInt(menu.length);
        String order = menu[ranNo];
        orderList.offer(order);
        showOrder();
    }
    private void service(){
        String serv = orderList.poll();
        this.serviceLabel.setText( "Servicing: " + serv + " Next order is:" + orderList.peek());
        showOrder();
    }
    public static void main(String[] args) {
        QueueFrame qf = new QueueFrame();
        qf.setSize(300,300);
        qf.setVisible(true);
        qf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
