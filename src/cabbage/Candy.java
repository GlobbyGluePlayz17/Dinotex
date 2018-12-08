package cabbage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Candy extends GameObject {
	
	
	Candy(int x, int y) {
		super(new Random().nextInt(499-1) + 1, new Random().nextInt(790-30) + 30, 25, 25);
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		super.update();
		collisionBox.setBounds(x, y, width, height);
	}
	
	public void draw(Graphics g) {
			g.drawImage(GamePanel.candyImg, x, y, width, height, null);
			//g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
	}	
}