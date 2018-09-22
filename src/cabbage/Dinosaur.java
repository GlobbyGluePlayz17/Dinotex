package cabbage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Robot;

import javax.swing.Timer;

public class Dinosaur
	int speed;
	Robot dino;

	Dinosaur() {
		speed = 10;
		dino = new Robot();
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		super.update();
	}	
	
	public void draw(Graphics g) {
		g.drawImage(GamePanel.dinoImg, x, y, null);
  	}
	
}
