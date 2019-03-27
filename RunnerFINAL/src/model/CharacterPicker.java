package model;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;

/**
 * The Class CharacterPicker.
 */
public class CharacterPicker extends VBox{
	
	/** The circle image. */
	private ImageView circleImage;
	
	/** The character image. */
	private ImageView characterImage;
	
	/** The circle not chosen. */
	private String circleNotChosen = "view/resources/characters/grey_circle.png";
	
	/** The circle chosen. */
	private String circleChosen = "view/resources/characters/circle_chosen.png";
	
	/** The character. */
	private CHARACTER character;
	
	/** The is circle chosen. */
	private boolean isCircleChosen;
	
	/**
	 * Instantiates a new character picker.
	 *
	 * @param character the character
	 */
	public CharacterPicker(CHARACTER character){
		circleImage = new ImageView(circleNotChosen);
		characterImage = new ImageView(character.getUrl());
		this.character = character;
		isCircleChosen = false;
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
		this.getChildren().add(circleImage);
		this.getChildren().add(characterImage);
		
	}
	
	/**
	 * Gets the character.
	 *
	 * @return the character
	 */
	public CHARACTER getCharacter(){
		return character;
	}
	
	/**
	 * Gets the circle is chosen.
	 *
	 * @return the circle is chosen
	 */
	public boolean getCircleIsChosen(){
		return isCircleChosen;
	}
	
	/**
	 * Sets the circle is chosen.
	 *
	 * @param isCircleChosen the new circle is chosen
	 */
	public void setCircleIsChosen(boolean isCircleChosen){
		this.isCircleChosen = isCircleChosen;
		String imageToSet = this.isCircleChosen ? circleChosen : circleNotChosen;
		circleImage.setImage(new Image(imageToSet));
	}
	
}
