package cabbage;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Dinosaur roc;
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int score;
	
	
	ObjectManager(Dinosaur rocket) {
		roc = rocket;
		score = 0;
	}
	
	public void update() {
		roc.update();
	}
	
	public void draw(Graphics g) {
		roc.draw(g);
		System.out.println(score);
	}

	public void scoreGetter() {
		this.score = score;
		System.out.println(score);
	}
}
