import java.util.Timer;


public class Obstacles {
	
public int width;
public int height;
public String name;

// CACTUS 1 - its width is 23 pixels and its height is 46 pixels	
// CACTUS 2 - which contains 3 cactuses - has W: 49 pixels, H: 33 pixels
	
public Obstacles(String nameof, int wiidth, int heeight) {
		this.name = nameof;
		this.width = wiidth;
		this.height = heeight; }
	
	}



		
/* the x is always dynamic, and the y would only change when dino jumps
 *each obstacle is an object from that class
 *
 * When the dino jumps
 * at what x and y? do you look for the intersection ?
 * during that timer 
 * How long is the jump ,, projectile in the x and y 
 * 
 * collision method would not change regardless if you are working in GUI or text based version
 */