package cabbage;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Timer;

public class Ghost extends GameObject{
	int speed;
	int width = 100;
	int height = 100;
	GameObject object;

	Ghost(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 20;
		object = new GameObject(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		super.update();
		collisionBox.setBounds(x, y, 100, 100);
	}	
	
	public void draw(Graphics g) {
		g.drawImage(GamePanel.ghostImg, x, y, 100, 100, null);
  	}
	
}
