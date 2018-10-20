package cabbage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Food extends GameObject {
	int randx = 5;
	int randy = 7;
	
	Food(int x, int y, int width, int height) {
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
			x+=5;
			g.drawImage(GamePanel.cloudImg, x*i, x*i, width, height, null);
		}
	}
}