package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

/**
 * The Class SmallInfoLabel.
 */
public class SmallInfoLabel extends Label {
	
	/** The Constant FONT_PATH. */
	private final static String FONT_PATH = "src/model/resources/kenvector_future.ttf";
	
	/**
	 * Instantiates a new small info label.
	 *
	 * @param text the text
	 */
	public SmallInfoLabel(String text){
		setPrefWidth(500);
		setPrefHeight(60);
		BackgroundImage backgroundImage = new BackgroundImage(
				new Image("/view/resources/red_small_panel.png", 200, 60, false, true), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,  BackgroundPosition.DEFAULT, null);
		setBackground(new Background(backgroundImage));
		setAlignment(Pos.CENTER_LEFT);
		setPadding(new Insets(10,10,10,10));
		setText(text);
		setLabelFont();
	}
	
	/**
	 * Sets the label font.
	 */
	private void setLabelFont(){
		
		try {
			setFont(Font.loadFont(new FileInputStream(new File(FONT_PATH)), 18));
		} catch (FileNotFoundException e){
			setFont(Font.font("Verdana", 18));
		}
		
	}

	
			
}
