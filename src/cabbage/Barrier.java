package cabbage;
import java.awt.Color;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.Timer;

public class Barrier extends GameObject {
	int randx;	
	int randy;

	
	Barrier(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		randx = new Random().nextInt(500);
		randy = new Random().nextInt(800);
	}
	
	public void update() {
		super.update();
		//y = 750;
		//System.out.println(rand);
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < 10; i++) {
			g.setColor(Color.BLUE);
			g.drawRect(randx, randy, width, height);
		}
	}
}