package model;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Background;

/**
 * The Class RunnerSubScene.
 */
public class RunnerSubScene extends SubScene {
	
	/** The Constant FONT_PATH. */
	private final static String FONT_PATH = "src/model/resources/kenvector_future.ttf";
	
	/** The Constant BACKGROUND_IMAGE. */
	private final static String BACKGROUND_IMAGE = "model/resources/red_panel.png";
	
	/** The is hidden. */
	private boolean isHidden = true;
	
	/**
	 * Instantiates a new runner sub scene.
	 */
	public RunnerSubScene(){
		super(new AnchorPane(), 600, 400);
		prefWidth(600);
		prefHeight(400);
		
		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 600, 400, false, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		
		AnchorPane root2 = (AnchorPane) this.getRoot();
		
		root2.setBackground(new Background(image));
		
		setLayoutX(1200);
		setLayoutY(180);
	}
	
	/**
	 * Move sub scene.
	 */
	public void moveSubScene(){
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);
		
		if (isHidden == true){
			transition.setToX(-840);
			isHidden = false;
		} else {
			transition.setToX(0);
			isHidden = true;
		}
		
		transition.play();
		
	}
	
	/**
	 * Gets the pane.
	 *
	 * @return the pane
	 */
	public AnchorPane getPane(){
		return (AnchorPane) this.getRoot();
	}
}
