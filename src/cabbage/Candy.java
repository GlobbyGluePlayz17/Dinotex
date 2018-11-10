package cabbage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Candy extends GameObject {
	int rand;
	static int width = 45;
	static	int height = 45;
	
	Candy(int x, int y) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		rand = new Random().nextInt(500);

	}
	
	public void update() {
		super.update();
		collisionBox.setBounds(x, y, width, height);
	}
	
	public void draw(Graphics g) {
			g.drawImage(GamePanel.candyImg, x, rand, width, height, null);
	}	
}