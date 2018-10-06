package cabbage;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.Timer;

public class Barrier extends GameObject{
	int 
	
	
	Barrier(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		object = new GameObject(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		super.update();
	}	
	
	public void draw(Graphics g) {
		g.drawRect(300, 350, 45, 5);
  	}
	
}
