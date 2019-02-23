package playerInterface;

import java.awt.Color;
import javax.swing.JPanel;

public class GameScreen extends JPanel implements Runnable {

	int i = 0;
	Thread thread;
	int z = 500;
	
	public GameScreen() {
		thread = new Thread(this);
	}
	
	public void startGame() {
		thread.start();
	}
	
	public void run() {
		while(true) {
			System.out.println(i ++);
			if (z >=150){
				z --;}
			try {
				Thread.sleep(z);
			} catch (InterruptedException e) {
				e.printStackTrace();	
			}
		}
	}
	
	
	
}
