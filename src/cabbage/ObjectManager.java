package cabbage;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Dinosaur dinosaur;
	ArrayList<Food> listFood;
	ArrayList<Barrier> listBarrier;
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int score;
	
	
	ObjectManager(Dinosaur dinosaurket) {
		dinosaur = dinosaurket;
		listBarrier = new ArrayList<Barrier>();
		listFood = new ArrayList<Food>();
		score = 0;
	}
	
	public void update() {
		for (int i = 0; i < listFood.size(); i++) {
			listFood.get(i).update();
		}
		for (int i = 0; i < listBarrier.size(); i++) {
			listBarrier.get(i).update();
		}
		dinosaur.update();
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < listFood.size(); i++) {
			listFood.get(i).draw(g);
		}
		for (int i = 0; i < listBarrier.size(); i++) {
			listBarrier.get(i).draw(g);
		}
		dinosaur.draw(g);
		
		System.out.println(listBarrier.size());
		System.out.println(listFood.size());
		System.out.println(score);
	}
	
	public void addAlien(Food foodADDlist) {
		listFood.add(foodADDlist);
	}
	public void addAlien(Barrier barrierADDlist) {
		listBarrier.add(barrierADDlist);
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
					System.out.println("asdfasdf");
				}
			}
	}
	
	
	public void checkCollision() {
			for (int i = 0; i < listFood.size(); i++) {
				if (listFood.get(i).collisionBox.intersects(dinosaur.collisionBox)) {
					listFood.get(i).isAlive = false;
					score++;
					System.out.println("asdfasdfasdf");
			}
		}
			System.out.println("asdf");
	}
	
	public void scoreGetter() {
		this.score = score;
		System.out.println(score);
	}
	
	public void initalizeFood() {

		for (int i = 0; i < listFood.size(); i++) {
			for (int j = 0; j < 8; j++) {
				listFood.add(new Food(listFood.get(i).x+=55, listFood.get(i).y, listFood.get(i).width, listFood.get(i).height));
				for (int j2 = 0; j2 < 1; j2++) {
					listFood.add(new Food(listFood.get(i).x+=55, listFood.get(i).y+=100, listFood.get(i).width, listFood.get(i).height));
				}
			}
		}
	}
}