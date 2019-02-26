package playerInterface;

import java.awt.Color;
import javax.swing.JPanel;
import java.util.Scanner;

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
			
			if (i % 5 == 0){
				System.out.println("Obstacle incoming, Press w to jump");
					long startTime = System.currentTimeMillis();
					Scanner s= new Scanner(System.in);
					char x = s.next().charAt(0);		
						if (x == 'w'){
							long elapsedTime = System.currentTimeMillis() - startTime;
							if (elapsedTime <= 1500){							
								System.out.println("Successfully jumped");}
							else {System.out.println("Game Over");
								System.exit(0);
							 						
				
				}
			}

			
			}

	    }
	}
}

