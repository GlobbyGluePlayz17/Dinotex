package cabbage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Food extends GameObject {
	int xx = 5;
	int yy = 7;
	ArrayList<Food> listFood;
	
	Food(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		
	}
	
	public void update() {
		super.update();
		//y = 750;
		//System.out.println(rand);
	}
	
	public void draw(Graphics g) {
		g.drawImage(GamePanel.cloudImg, xx, yy, width, height, null);
	}
}