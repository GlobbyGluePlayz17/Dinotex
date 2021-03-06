package cabbage;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Ghost dinosaur;
	ArrayList<Candy> listFood;
	ArrayList<Barrier> listBarrier;
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int score;
	Random rand;
	
	
	ObjectManager(Ghost dinosaurket) {
		dinosaur = dinosaurket;
		listBarrier = new ArrayList<Barrier>();
		listFood = new ArrayList<Candy>();
		score = 0;
		rand = new Random();
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
	
	public void addAlien(Candy foodADDlist) {
		listFood.add(foodADDlist);
	}
	public void addAlien(Barrier barrierADDlist) {
		listBarrier.add(barrierADDlist);
	}
	
//	public void manageEnemies(){
//	        if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
//	                addAlien(new Candy(new Random().nextInt(TrickorTreat.Width), 0));
//
//	enemyTimer = System.currentTimeMillis();     
//	
//	        }
//	}
		
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
		
		for (int i = 0; i < 100; i++) {
			listFood.add(new Candy(rand.nextInt(500), rand.nextInt(800)));
		}
	}
}