/**
 * Credit to "javacraving" user from Youtube for showing how 
 * to set up scenes, looping obstacles and GameViewManager.
 * Link:
 * https://www.youtube.com/watch?v=6BKI26gxK2Q&list=PL4wcbt63yAbdtY-GOeuRjIePfUsukSJZ9&index=2
 */
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
