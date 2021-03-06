package cabbage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer timer1;
	long enemyTimer;
	int enemySpawnTime;
	long totalTime;
	long elapsedTime;
	long beginningTime;
	long pastscore;
	
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	
	Font titleFont;
	Font titleFont2;
	Font	 GameOverFont;
	Font SubFont;
	Font RegularFont;
	
	Ghost ghost;
	ObjectManager om;
	Boolean setup;
	Boolean moveup;
	Boolean movedown;
	Boolean moveleft;
	Boolean moveright;

	public static BufferedImage candyImg;
	public static BufferedImage ghostImg;
	public static BufferedImage bgImg;
	
	GamePanel() {
		timer1 = new Timer(1000/60, this);
		enemyTimer = 0;
		enemySpawnTime = 1000;
		beginningTime = System.currentTimeMillis();
		
		titleFont = new Font("Comic Sans", Font.PLAIN, 80);
		titleFont2 = new Font("Comic Sans", Font.PLAIN, 65);
		GameOverFont = new Font("Comic Sans", Font.PLAIN, 48);
		SubFont = new Font("Comic Sans", Font.PLAIN, 30);
		RegularFont = new Font("Comic Sans", Font.PLAIN, 20);
		
		ghost = new Ghost(200, 650, 50, 50);
		om = new ObjectManager(ghost);
		setup = false;
		moveup = false;
		movedown = false;
		moveleft = false;
		moveright = false;
		
		 try {

             candyImg = ImageIO.read(this.getClass().getResourceAsStream("candy.png"));

             ghostImg = ImageIO.read(this.getClass().getResourceAsStream("ghosttrickortreat.png"));
             
             bgImg = ImageIO.read(this.getClass().getResourceAsStream("bg.png"));
             
             
     } catch (IOException e) {

             // TODO Auto-generated catch block

             e.printStackTrace();

     	}
	}
	
	public void startGame() {
		timer1.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MOVE();
		
		repaint();
		 if (currentState == MENU_STATE) {
			 updateMenuState();
		 } else if (currentState == GAME_STATE) {
			updateGameState();
		 } else if (currentState == END_STATE) {
			updateEndState();
		 }
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("test");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("tesser");
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			if (currentState == 0) {
				currentState = 1;
			} else if (currentState == 1) {
				currentState = 2;
			} else if (currentState == 2) {
				ghost = new Ghost(220, 700, 50, 50);
				om = new ObjectManager(ghost);
				beginningTime = System.currentTimeMillis();
				setup = false;
				currentState = 0;
				//om.draw(g);
			} 
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			moveup = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			movedown = true;
		}
		if (e.getKeyCode()== KeyEvent.VK_LEFT) {
			moveleft = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveright = true;
		}
			
//			} else if (e.getKeyCode() == KeyEvent.VK_UP + KeyEvent.VK_LEFT) {
//				ghost.x-=ghost.speed;
//				ghost.y-=ghost.speed;
//			} else if (e.getKeyCode() == KeyEvent.VK_UP + KeyEvent.VK_RIGHT) {
//				ghost.x+=ghost.speed;
//				ghost.y-=ghost.speed;
//			} else if (e.getKeyCode() == KeyEvent.VK_DOWN + KeyEvent.VK_LEFT) {
//				ghost.x-=ghost.speed;
//				ghost.y+=ghost.speed;
//			} else if (e.getKeyCode() == KeyEvent.VK_DOWN + KeyEvent.VK_RIGHT) {
//				ghost.x+=ghost.speed;
//				ghost.y+=ghost.speed;
//			}
		
			System.out.println(currentState);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("set");
		moveup = false;
		movedown = false;
		moveleft = false;
		moveright = false;
	}
	
	
	
	@Override
	public void paintComponent(Graphics g){
		 if (currentState == MENU_STATE) {
			 drawMenuState(g);
		 } else if (currentState == GAME_STATE) {
			if (setup == false) {
				 om.initalizeFood();
				 setup = true;
			}
			drawGameState(g);
		 } else if (currentState == END_STATE) {
			drawEndState(g);
		 }
	}
	
	public void updateMenuState() {
		
	}
	
	public void updateGameState() {
		om.update();
		//om.manageEnemies();
		om.checkCollision();
		om.purgeObjects();
		gameTimer();
		System.out.println(om.score);
	
	}
	
	public void updateEndState() {
	
	}
	
	public void drawMenuState(Graphics g) {
		g.drawImage(GamePanel.ghostImg, 1, 105, 500, 500, null);
		g.setColor(Color.BLACK);
		g.setFont(titleFont2);
		g.drawString("Trick or Treat!", 35, 185);
		g.setFont(RegularFont);
		g.drawString("Help the ghost to collect as much candy", 54, 550);
		g.drawString("as possible in the least amount of time!", 84, 585);
		g.drawString("Use arrow keys to move.", 138, 635);
		g.setFont(SubFont);
		g.drawString("Press ENTER to Play", 102, 720);
		
	}
	
//	public void SETUP() {
//		if (setup == true) {
//			om.initalizeFood();
//			setup = false;
//		}
//	}
	
	public void MOVE() {
		if (moveup == true) {
			ghost.y-=ghost.speed;
		} else if (movedown == true) {
			ghost.y+=ghost.speed;
		} else if (moveleft == true) {
			ghost.x-=ghost.speed;
		} else if (moveright == true) {
			ghost.x+=ghost.speed;
		}
	}
	
	public void gameTimer() {
        elapsedTime = System.currentTimeMillis() - beginningTime;
        totalTime = elapsedTime/1000;
  
	}
	

	public void drawGameState(Graphics g) {
		setup = true; 
		g.setColor(Color.RED);
		//g.fillRect(0, 0, 500, 800);
		g.drawImage(bgImg, 0, 0, 500, 800, null);
		g.setFont(RegularFont);
		g.drawString("Candy Count: " + om.score, 10, 30);
		g.drawString("Time: " + totalTime, 395, 30);
		om.draw(g);
		if (om.score == 100) {
			currentState = 2;
		}
		
	}
	
	public void drawEndState(Graphics g) {
		g.drawImage(GamePanel.ghostImg, 1, 105, 500, 500, null);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Game Over", 47, 200);
		g.setFont(SubFont);
		g.drawString("Press ENTER to Reset", 93, 550);
		g.setFont(RegularFont);
		g.drawString("You collected " + om.score + " candy in " + totalTime + " seconds.", 75, 600);
		g.drawString("Now try to beat your score!", 117, 630);
	}
	
}