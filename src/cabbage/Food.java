package cabbage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Food extends GameObject {
	int num = new Random().nextInt(500);
	int newnum = num*20;
	int num2 = new Random ().nextInt(800);
	int newnum2 = num2*30;
	
	
	Food(int x, int y, int width, int height) {
		super(newnum, newnum2, width, height);
		// TODO Auto-generated constructor stub
		
	}
	
	public void update() {
		super.update();
		//y = 750;
		//System.out.println(rand);
	}
	
	public void draw(Graphics g) {
		g.drawImage(GamePanel.cloudImg, x, y, width, height, null);
		//System.out.println("weteg");
	}
}