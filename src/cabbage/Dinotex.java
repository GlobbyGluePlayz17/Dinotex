package cabbage;
import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Dinotex {
	JFrame frame;
	final static int Width = 500;
	final static int Height = 800;
	GamePanel gp1;
	
	Dinotex() {
		frame = new JFrame();
		gp1 = new GamePanel();
	}
	
	public void setup() {
		frame.getContentPane().setPreferredSize(new Dimension(Width, Height));
		frame.pack();
		frame.add(gp1);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gp1.startGame();
		frame.addKeyListener(gp1);
	}
	
	public static void main(String[] args) {
		Dinotex dt1 = new Dinotex();
		dt1.setup();
	}
}
