package application;


import javafx.application.Application;
import view.ViewManager;
import javafx.stage.Stage;

/**
 * The Class Main.
 */
public class Main extends Application {
	
	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage){
		try {
			ViewManager manager = new ViewManager();
			primaryStage = manager.getMainStage();
			primaryStage.show();
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		launch(args);
	}
}
