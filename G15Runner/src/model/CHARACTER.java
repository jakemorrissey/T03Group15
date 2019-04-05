package model;

// TODO: Auto-generated Javadoc
/**
 * The Enum CHARACTER.
 */
public enum CHARACTER {
	
	/** The adventurer. */
	ADVENTURER("view/resources/characters/adventurer_walk1.png"),
	
	/** The zombie. */
	ZOMBIE("view/resources/characters/zombie_walk1.png"),
	
	/** The woman. */
	WOMAN("view/resources/characters/female_walk1.png"),
	
	/** The soldier. */
	SOLDIER("view/resources/characters/soldier_walk1.png");

	/** The url character. */
	private String urlCharacter;
	
	/**
	 * Instantiates a new character.
	 *
	 * @param urlCharacter the url character
	 */
	private CHARACTER(String urlCharacter){
		this.urlCharacter = urlCharacter;
	}
	
	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl(){
		return this.urlCharacter;
	}
	
	
}
