package PlayerInterface;

import javax.swing.JPanel;

public class GameScreen extends JPanel implements Runnable {
	
	//Variables
	int score = 0;
	int time = 1000;
	Thread thread;
	
	//Constructors
	public GameScreen() {
		thread = new Thread(this);
	}
	
	//Methods
	public void startGame() {
		thread.start();
	}
	
	public void run() { //from Runnable
		while(true) {
			if (score > 100) {
				time = 100;
			}
			
			else if (score > 50) {
				time = 400;
			}
			
			else if (score > 20) {
				time = 700;
			}
			
			System.out.println(score ++);
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
