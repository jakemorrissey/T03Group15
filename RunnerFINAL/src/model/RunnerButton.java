package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

// TODO: Auto-generated Javadoc
/**
 * The Class RunnerButton.
 */
public class RunnerButton extends Button {
	
	/** The font path. */
	private final String FONT_PATH = "src/model/resources/kenvector_future.ttf";
	
	/** The button free style. */
	private final String BUTTON_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/model/resources/red_button.png');";
	
	/** The button pressed style. */
	private final String BUTTON_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/model/resources/red_button_pressed.png');";
	
	/**
	 * Instantiates a new runner button.
	 *
	 * @param text the text
	 */
	public RunnerButton(String text){
		setText(text);
		setButtonFont();
		setPrefWidth(190);
		setPrefHeight(49);
		setStyle(BUTTON_FREE_STYLE);
		initializeButtonListeners();
	}
	
	/**
	 * Sets the button font.
	 */
	private void setButtonFont(){
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
		} catch(FileNotFoundException e){
			setFont(Font.font("Verdana", 23));
		}
		
	}
	
	/**
	 * Sets the button pressed style.
	 */
	private void setButtonPressedStyle(){
		setStyle(BUTTON_PRESSED_STYLE);
		setPrefHeight(45);
		setLayoutY(getLayoutY() + 4);
		
	}
	
	/**
	 * Sets the button released style.
	 */
	private void setButtonReleasedStyle(){
		setStyle(BUTTON_FREE_STYLE);
		setPrefHeight(49);
		setLayoutY(getLayoutY() - 4);
		
	}
	
	/**
	 * Initialize button listeners.
	 */
	private void initializeButtonListeners(){
		
		setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event){
				if(event.getButton().equals(MouseButton.PRIMARY)){
					setButtonPressedStyle();
				}
			}
				
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event){
				if(event.getButton().equals(MouseButton.PRIMARY)){
					setButtonReleasedStyle();
				}
			}
			
			
		});
		
	setOnMouseEntered(new EventHandler<MouseEvent>(){

		@Override
		public void handle(MouseEvent event) {
			setEffect(new DropShadow());

			
		}
		
	});
	setOnMouseExited(new EventHandler<MouseEvent>(){

		@Override
		public void handle(MouseEvent event) {
			setEffect(null);

			
		}
		
	});

	}
	
	
	
	
	
	
	
}
