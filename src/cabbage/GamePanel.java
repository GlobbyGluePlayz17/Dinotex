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

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer timer1;
	
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	
	Font titleFont;
	Font	 GameOverFont;
	Font SubFont;
	Font RegularFont;
	Dinosaur dinosaur;
	ObjectManager om;

	public static BufferedImage cloudImg;
	public static BufferedImage dinoImg;
	public static BufferedImage bgImg;
	
	GamePanel() {
		timer1 = new Timer(1000/60, this);
		titleFont = new Font("Comic Sans", Font.PLAIN, 80);
		GameOverFont = new Font("Comic Sans", Font.PLAIN, 48);
		SubFont = new Font("Comic Sans", Font.PLAIN, 30);
		RegularFont = new Font("Comic Sans", Font.PLAIN, 20);
		dinosaur = new Dinosaur(220, 700, 50, 50);
		om = new ObjectManager(dinosaur);
		
		 try {

             cloudImg = ImageIO.read(this.getClass().getResourceAsStream("cloud.png"));

             dinoImg = ImageIO.read(this.getClass().getResourceAsStream("dinotexdino.png"));
             
             bgImg = ImageIO.read(this.getClass().getResourceAsStream("bg.jpg"));
             
             
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
				dinosaur = new Dinosaur(220, 700, 50, 50);
				om = new ObjectManager(dinosaur);
				currentState = 0;
			} 
		}
			System.out.println(currentState);
		
		if (e.getKeyCode()== KeyEvent.VK_LEFT) {
			dinosaur.x-=dinosaur.speed;
			System.out.println("left");
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			dinosaur.x+=dinosaur.speed;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			dinosaur.y-=dinosaur.speed;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			dinosaur.y+=dinosaur.speed;
		} else if (e.getKeyCode() == KeyEvent.VK_UP + KeyEvent.VK_LEFT) {
			dinosaur.x-=dinosaur.speed;
			dinosaur.y-=dinosaur.speed;
		} else if (e.getKeyCode() == KeyEvent.VK_UP + KeyEvent.VK_RIGHT) {
			dinosaur.x+=dinosaur.speed;
			dinosaur.y-=dinosaur.speed;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN + KeyEvent.VK_LEFT) {
			dinosaur.x-=dinosaur.speed;
			dinosaur.y+=dinosaur.speed;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN + KeyEvent.VK_RIGHT) {
			dinosaur.x+=dinosaur.speed;
			dinosaur.y+=dinosaur.speed;
		} 
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("set");
	}
	
	@Override
	public void paintComponent(Graphics g){
		 if (currentState == MENU_STATE) {
			 drawMenuState(g);
		 } else if (currentState == GAME_STATE) {
			drawGameState(g);
		 } else if (currentState == END_STATE) {
			drawEndState(g);
		 }
	}
	
	public void updateMenuState() {
		
	}
	
	public void updateGameState() {
		om.update();
		om.manageEnemies();
		om.checkCollision();
		om.purgeObjects();
		System.out.println(om.score);
	
	}
	
	public void updateEndState() {
		
	}
	
	public void drawMenuState(Graphics g) {
		g.drawImage(GamePanel.dinoImg, 1, 105, 500, 500, null);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Dinotex", 95, 250);
		g.setFont(SubFont);
		g.drawString("Press ENTER to Play", 102, 400);
	}
	
	public void drawGameState(Graphics g) {
		g.drawImage(GamePanel.bgImg, 0, 0, 500, 800, null);
		om.draw(g);
	}
	
	public void drawEndState(Graphics g) {
		g.drawImage(GamePanel.dinoImg, 1, 105, 500, 500, null);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Game Over", 47, 200);
		g.setFont(SubFont);
		g.drawString("Press ENTER to Reset", 93, 300);
		g.setFont(RegularFont);
		g.drawString("You ate "+ om.score + " cloud(s). \n Better luck next time!", 45, 500);
	}
}
