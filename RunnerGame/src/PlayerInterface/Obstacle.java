package PlayerInterface;

import java.util.Random;

public class Obstacle {

	//Variables
	int distance = 50;
	Random sizeNum = new Random();
	int size = sizeNum.nextInt(3) + 1;
	
	//Constructors
	public Obstacle() {
		
	}
	
	//Methods
	public void lowerDist() {
		distance --;
	}
}
