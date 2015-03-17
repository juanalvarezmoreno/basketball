import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class BasketBall {

	private static int width = 400;
	private static int height = 400;
	private int y = height/2;
	private int x = width/2;
	private int v=0;
	private int vh=5;
	private int r=5;
	
	
	public static void main(String[] args) {
		
		final BasketBall b = new BasketBall();
		
		
		JPanel panel = new JPanel() {
		
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(new Color(0xffffff));
				g.fillRect(0,-200, 10, 1000);
				g.fillRect(height,-200, 10, 1000);
				g.fillOval(b.x-b.r, b.y-b.r, 2*b.r, 2*b.r);
				
			}	
			
			
			
		};
		
		
		panel.setBackground(Color.black);
		
		
		JFrame frame = new JFrame();
		frame.setContentPane(panel);
		panel.setSize(b.width, b.height);
		
		frame.setSize(400,200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		while (true) {
			b.simulate();
			panel.repaint();
			
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void simulate() {
		
		//vertical
		
		y = y + v;
		v = v -1;
		if (y <= r) {
			v = -v;	
		}
		
		//horizontal
		x = x+vh;
		if (x >= (height-r)) {
			vh = -vh;	
		}
		if (x <= r) {
			vh = -vh;	
		}
		
		//rare
		if (y<=r){
			r=r+1;
		} 
		
		
	}
}
	
	
