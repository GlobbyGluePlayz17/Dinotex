package cabbage;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Dinosaur dinosaur;
	ArrayList<Food> listFood;
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int score;
	
	
	ObjectManager(Dinosaur dinosaurket) {
		dinosaur = dinosaurket;
		listFood = new ArrayList<Food>();
		score = 0;
	}
	
	public void update() {
		for (int i = 0; i < listFood.size(); i++) {
			listFood.get(i).update();
		}
		dinosaur.update();
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < listFood.size(); i++) {
			listFood.get(i).draw(g);
			//System.out.println("asdf");
		}
		dinosaur.draw(g);
		
		System.out.println(listFood.size());
		System.out.println(score);
	}
	
	public void addAlien(Food foodADDlist) {
		listFood.add(foodADDlist);
	}
	
		public void manageEnemies(){
	        if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
	                addAlien(new Food(new Random().nextInt(Dinotex.Width), 0, 50, 50));

	enemyTimer = System.currentTimeMillis();
	        }
	}
		
	public void purgeObjects() {
			for (int i = 0; i < listFood.size(); i++) {
				if (listFood.get(i).isAlive == false) {
					listFood.remove(i);
					//System.out.println("asdfasdf");
				}
			}
	}
	
	
	public void checkCollision() {
			for (int i = 0; i < listFood.size(); i++) {
				if (listFood.get(i).collisionBox.intersects(dinosaur.collisionBox)) {
					listFood.get(i).isAlive = false;
					score++;
			}
		}
	}
	
	public void scoreGetter() {
		this.score = score;
		System.out.println(score);
	}
}
