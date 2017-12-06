
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class QueueMenu extends JFrame{
	JButton serviceBtn;
	JButton orderBtn;
	JTextArea orderList;
	JLabel serviceLbl;
	String menu[] = {"Pizza","Pasta","Ice cream", "Pudding"};
	LinkedList<String> orders = new LinkedList<String>();
	
	public QueueMenu(){
		serviceBtn = new JButton("Service");
		orderBtn = new JButton("Order");
		orderList = new JTextArea(20,20);
		serviceLbl = new JLabel(" ");
				
		this.add(orderList);
		this.add(serviceLbl,BorderLayout.NORTH);
		JPanel p = new JPanel();
		p.add(orderBtn);
		p.add(serviceBtn);
		this.add(p,BorderLayout.SOUTH);
		
		orderBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Random ran = new Random();
				int index = ran.nextInt(menu.length);
				orders.offer(menu[index]);
				
				StringBuffer sb = new StringBuffer();
				for (String s: orders){
					sb.append(s + "\n");
				}
				orderList.setText(sb.toString());
			}
		});
		
		serviceBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = orders.peek();
				if (s == null){
					serviceLbl.setText("No order");
				}else{
					serviceLbl.setText(orders.poll());
				}
				StringBuffer sb = new StringBuffer();
				for (String ss: orders){
					sb.append(ss + "\n");
				}
				orderList.setText(sb.toString());
				
			}
		});
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		QueueMenu qm = new QueueMenu();
		

	}

}
