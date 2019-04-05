package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

/**
 * The Class InfoLabel.
 */
public class InfoLabel extends Label{
	
	/** The Constant FONT_PATH. */
	public final static String FONT_PATH = "src/model/resources/kenvector_future.ttf";
	
	/** The Constant BACKGROUND_IMAGE. */
	public final static String BACKGROUND_IMAGE = "view/resources/red_small_panel.png";
	
	
	/**
	 * Instantiates a new info label.
	 *
	 * @param text the text
	 */
	public InfoLabel(String text){
		
		setPrefWidth(380);
		setPrefHeight(49);
		setText(text);
		setWrapText(true);
		setLabelFont();
		setAlignment(Pos.CENTER);
		
		BackgroundImage backgroundImage = new BackgroundImage(new Image(BACKGROUND_IMAGE, 380, 49, false, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);
		setBackground(new Background(backgroundImage));
	}
	
	/**
	 * Sets the label font.
	 */
	private void setLabelFont(){
		
		try {
			setFont(Font.loadFont(new FileInputStream(new File(FONT_PATH)), 23));
		}catch (FileNotFoundException e) {
			setFont(Font.font("Verdana", 23));

		}
	}
	
}
