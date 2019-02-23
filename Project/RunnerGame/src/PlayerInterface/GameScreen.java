package PlayerInterface;

import java.awt.Color;
import javax.swing.JPanel;

public class GameScreen extends JPanel implements Runnable {

	int i = 0;
	Thread thread;
	
	public GameScreen() {
		thread = new Thread(this);
	}
	
	public void startGame() {
		thread.start();
	}
	
	public void run() {
		while(true) {
			System.out.println(i ++);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
