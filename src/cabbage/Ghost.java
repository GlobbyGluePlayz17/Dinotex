package cabbage;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Timer;

public class Ghost extends GameObject{
	int speed;
	GameObject object;

	Ghost(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		object = new GameObject(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		super.update();
		collisionBox.setBounds(x, y, width, height);
	}	
	
	public void draw(Graphics g) {
		g.drawImage(GamePanel.ghostImg, x, y, width, height, null);
  	}
	
}
