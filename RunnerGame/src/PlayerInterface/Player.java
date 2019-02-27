/*Trex - 40 pixels wide 
 *      43 pixels tall 
 *      
 *      Its jump must be > 46 pixels (height of single cactus)
 */


public class Player {
	
	private int plX=0;  // starting x-coordinate for image (where top left is 0,0) (first column of pixels)
	private int plY=137;  // starting y-coordinate for image (top row of pixels)
	private int plWidth=40;
	private int plHeight=43;
	
	// y range of canvas - 200 pixels
	// floor starts at 180 pixels
	// 180 (floor) - height of trex (43) = 137 Y - starting coordinate
	
	
	public int gety() {
		return this.plY;
	}
	public int getx() {
		return this.plX;
	}

	public int getWidth() {
		return this.plWidth;
	}

	public int getHeight() {
		return this.plHeight;
	}


	}
		

	
// Suppose pressing the jump button lifts avatar by 46 pixels.	
// Suppose the floor background horizon line is set around 180 (y-axis) out of 200.
