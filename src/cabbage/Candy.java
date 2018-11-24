package cabbage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Candy extends GameObject {
	
	
	Candy(int x, int y) {
		super(x, new Random().nextInt(800), 25, 25);
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		super.update();
		collisionBox.setBounds(x, y, 100, 100);
	}
	
	public void draw(Graphics g) {
			g.drawImage(GamePanel.candyImg, x, y, width, height, null);
	}	
}