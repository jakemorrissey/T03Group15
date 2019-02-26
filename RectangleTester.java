package shape;
/**
 * YalchinALV (2017, March 30). Runner. Retrieved February 25, 2019, from https://github.com/yalchinAlv/Runner
 * Source: Yalchin Aliyev
**/
import java.util.Scanner;

public class RectangleTester {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Scanner in = new Scanner(System.in);

		// variables
		int  option, width, length;

		System.out.print( "Enter width and length: ");
		width = scan.nextInt();
		length = scan.nextInt();
do {
		menu();
		System.out.print("Select an option: ");
		option = scan.nextInt();	
		if ( option == 1) {

			if ( width > 0 && length > 0) {
				System.out.println( "The rectangle's area is " + width*length + " units squared!");
			}
			else 
				System.out.println( "ERROR! Width and length should be positive integers!");
		}
		if ( option == 2) {
			if ( width > 0 && length > 0) {

				System.out.println( "The rectangle's perimeter is " + (width+length+width+length) + " units!");
			}
			else 
				System.out.println( "ERROR! Width and length should be positive integers!");
	}
		if ( option == 3) {
			System.out.print( "Width: " + width);
			System.out.print( " length: " + length);
	}
} while ( option != 4);
System.out.println( "Bye Bye!");

			
}
	// menu
	private static void menu() {

		System.out.println( "\n|--------------------------------------------------|\n"
							+ "|(1) Compute Area----------------------------------|\n"
							+ "|(2) Compute Perimeter-----------------------------|\n"
							+ "|(3)Display Dimensions-----------------------------|\n"
							+ "|(4)Quit-------------------------------------------|\n");
	}
}
