package cabbage;
import java.awt.Color;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.Timer;

public class Barrier extends GameObject {
	Barrier[] barrier = new Barrier[20];
	int randx = new Random().nextInt(500);
	int randy = new Random().nextInt(800);
	int randw = new Random().nextInt(100);
	int randh = new Random().nextInt(100);
	
	
	Barrier(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		
	}
	
	public void update() {
		super.update();
		//y = 750;
		//System.out.println(rand);
	}
	
	public void draw(Graphics g) {
		g.fillRect(x, y, width, height);
		System.out.println("drawing the food");
}	
}