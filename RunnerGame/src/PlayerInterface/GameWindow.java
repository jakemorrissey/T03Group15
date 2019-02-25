package PlayerInterface;

import javax.swing.JFrame;
import java.awt.Graphics;

public class GameWindow extends JFrame {
	
	//Variables
	private GameScreen gameScreen;
	
	//Constructors
	public GameWindow() {
		super("Java Runner Game");
		setSize(800, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		gameScreen = new GameScreen();
		add(gameScreen);
	}
	
	//Methods
	public void startGame() {
		gameScreen.startGame();
	}
	
	public static void main(String[] args) {
		GameWindow gw = new GameWindow();
		gw.setVisible(true);
		gw.startGame();
	}
	
	
	
	
	
	
}
