

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PolygonTest extends JPanel{
	public PolygonTest(){
		setPreferredSize(new Dimension(100,100));
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		int xPoints[] = {0,	0,			getWidth()};
		int yPoints[] = {0, getHeight(),getHeight()};
		g.fillPolygon(xPoints, yPoints, 3);
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		PolygonTest p = new PolygonTest();
		f.add(p);
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
