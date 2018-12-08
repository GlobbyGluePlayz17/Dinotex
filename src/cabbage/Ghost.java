package cabbage;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Timer;

public class Ghost extends GameObject{
	int speed;
	int width = 70;
	int height = 70;

	Ghost(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 3;
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		super.update();
		collisionBox.setBounds(x+20, y+20, width-40, height-40);
		//System.out.println("collision" + collisionBox.x + collisionBox.y);
	}	
	
	public void draw(Graphics g) {
		g.drawImage(GamePanel.ghostImg, x, y, width, height, null);
		//g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
  	}
	
}
