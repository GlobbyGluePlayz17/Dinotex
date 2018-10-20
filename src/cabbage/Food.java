package cabbage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Food extends GameObject {
	int x;
	int y;
	int xspacing = 55;
	int yspacing = 100;
	
	Food(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		this.x = 5;
		this.y = 7;
	}
	
	
	public void update() {
		super.update();
		//y = 750;
		//System.out.println(rand);
	}
	
	public void draw(Graphics g) {
			g.drawImage(GamePanel.cloudImg, x, y, width, height, null);
			//System.out.println("drawing the food");
			for (int i = 0; i < 1; i++) {
				g.drawImage(GamePanel.cloudImg, x+xspacing*i, y, width, height, null);
			}
	}	
}