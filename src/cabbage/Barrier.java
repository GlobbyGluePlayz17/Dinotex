package cabbage;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.Timer;

public class Barrier extends GameObject{
	int xx = new Random().nextInt(100);
	int xxx = xx*5;
	int yy = new Random().nextInt(80);
	int yyy = yy*10;
	int weed = new Random().nextInt(100);
	int hit = new Random().nextInt(100);
	int numofbarir = new Random().nextInt(10);
	GameObject object;
	
	Barrier(int x, int y, int width, int height) {
		super(x, y, width, height);
		object = new GameObject(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		super.update();
	}	
	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(xxx, yyy, weed, hit);
  	}
	
}
