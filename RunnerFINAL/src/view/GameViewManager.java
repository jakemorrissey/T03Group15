package view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.CHARACTER;
import model.InfoLabel;
import model.RunnerButton;
import model.RunnerSubScene;
import model.SmallInfoLabel;
// TODO: Auto-generated Javadoc

/**
 * The Class GameViewManager.
 */
public class GameViewManager extends ViewManager {
	
	/** The keys. */
	protected HashMap<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>();
	
	/** The game pane. */
	protected AnchorPane gamePane;
	
	/** The game scene. */
	protected Scene gameScene;
	
	/** The game stage. */
	protected Stage gameStage;
	
	/** The menu stage. */
	protected Stage menuStage;
	
	/** The ground pane 1. */
	protected BorderPane groundPane1;
	
	/** The ground pane 2. */
	protected BorderPane groundPane2;
	
	/** The ground pane 3. */
	protected BorderPane groundPane3;
	
	/** The ground pane 4. */
	protected BorderPane groundPane4;
	
	/** The ground pane 5. */
	protected BorderPane groundPane5;
	
	/** The ground pane 6. */
	protected BorderPane groundPane6;
    
    /** The time line. */
    Timeline timeLine = new Timeline();
    
    protected TextField usrNameTxt;
    
    /** The game over sub scene. */
    private RunnerSubScene gameOverSubScene;
	
	/** The grid pane 1. */
	protected GridPane gridPane1;
	
	/** The grid pane 2. */
	protected GridPane gridPane2;
	
	/** The grid pane 3. */
	protected GridPane gridPane3;
	
	/** The character. */
	protected ImageView character;
	
	
	/** The platforms. */
	protected ArrayList<Node> platforms = new ArrayList<Node>();
	
	/** The Constant BACKGROUND_IMAGE. */
	protected final static String BACKGROUND_IMAGE = "view/resources/background.png";
	
	/** The Constant GROUND_IMAGE. */
	protected final static String GROUND_IMAGE = "view/resources/ground.png";
	
	/** The Constant GAME_WIDTH. */
	protected static final int GAME_WIDTH = 1200;
	
	/** The Constant GAME_HEIGHT. */
	protected static final int GAME_HEIGHT = 550;
	
	/** The move speed. */
	protected double moveSpeed = 9;
	
	/** The images. */
	List<Image> images = new ArrayList<>();
	
	/** The chosen character url. */
	protected String chosenCharacterUrl;
	
	/** The player view. */
	ImageView playerView = new ImageView();
	
	/** The sprites. */
	List<Image> sprites = new ArrayList<>();
	
	
	/** The Constant adventurer1. */
	protected final static String adventurer1 = "view/resources/characters/adventurer_walk1.png";
	
	/** The Constant adventurer2. */
	protected final static String adventurer2 = "view/resources/characters/adventurer_walk2.png";
	
	/** The Constant zombie1. */
	protected final static String zombie1 = "view/resources/characters/zombie_walk1.png";
	
	/** The Constant zombie2. */
	protected final static String zombie2 = "view/resources/characters/zombie_walk2.png";
	
	/** The Constant female1. */
	protected final static String female1 = "view/resources/characters/female_walk1.png";
	
	/** The Constant female2. */
	protected final static String female2 = "view/resources/characters/female_walk2.png";
	
	/** The Constant soldier1. */
	protected final static String soldier1 = "view/resources/characters/soldier_walk1.png";
	
	/** The Constant soldier2. */
	protected final static String soldier2 = "view/resources/characters/soldier_walk2.png";
	
	/** The score. */
	public int score = 0;
	
	/** The main menu button. */
	protected RunnerButton mainMenuButton;
	
	
	/** The slime 1. */
	protected ImageView slime1;
	
	/** The slime 2. */
	protected ImageView slime2;
	
	/** The player sprites. */
	protected Image[] playerSprites;
	
	/** The Constant SLIME_IMAGE. */
	protected final static String SLIME_IMAGE = "view/resources/enemies/slime1.png";
	
	/** The Constant SLIME2_IMAGE. */
	protected final static String SLIME2_IMAGE = "view/resources/enemies/slime.png";
	
	/** The can jump. */
	protected boolean canJump = true;
	
	/** The game timer. */
	protected AnimationTimer gameTimer;
    
    /** The player velocity. */
    protected Point2D playerVelocity = new Point2D(0, 0);
    
    /** The points label. */
    protected SmallInfoLabel pointsLabel;
    
    /** The final score label. */
    protected SmallInfoLabel finalScoreLabel;
    
    /** The high score label. */
    protected SmallInfoLabel highScoreLabel;

	/** the high score. */
    private int highScore;
	
	
	/**
	 * Instantiates a new game view manager.
	 */
	public GameViewManager(){
		initializeStage();
	}
	
	/**
	 * Initialize stage.
	 */
	public void initializeStage(){
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
        gameScene.setOnKeyPressed(event -> keys.put(event.getCode(), true));
        gameScene.setOnKeyReleased(event -> keys.put(event.getCode(), false));
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		
	}
	
	/**
	 * Creates the new game.
	 *
	 * @param menuStage the menu stage
	 * @param chosenCharacter the chosen character
	 */
	public void createNewGame(Stage menuStage, CHARACTER chosenCharacter){
		this.menuStage = menuStage;
		this.menuStage.hide();
		createBackground();
		createCharacter(chosenCharacter);
		animateCorrectSprite();
		createScoreLabel();
		createGameElements();
        File scoreFolder = new File("Scores");
        File scoreTxt = new File (scoreFolder + "/" + "Score.txt");
		createPlatform();
		createGameLoop();
		createMainMenuButton();
		gameStage.setResizable(false);
		gameStage.show();
		
		
	}
	
	/**
	 * Creates the character.
	 *
	 * @param chosenCharacter the chosen character
	 */
	protected void createCharacter(CHARACTER chosenCharacter){
		character = new ImageView(chosenCharacter.getUrl());
		character.setLayoutY(((GAME_HEIGHT /4) * 3)-12);
		character.setLayoutX(GAME_WIDTH - 1020);
		gamePane.getChildren().add(character);
		chosenCharacterUrl = chosenCharacter.getUrl();
	}
	
    /**
     * Move player up.
     */
    protected void movePlayerUp() {
        if (canJump) {
            playerVelocity = playerVelocity.add(0, -30);
            canJump = false;
        }
    }
	
	/**
	 * Creates the game loop.
	 */
	protected void createGameLoop(){
		gameTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				moveBackground();
				moveGround();
				moveGameElements();
				checkCollision();
				checkIfObstaclesPast();
		        update();
				
			}
		};
		
		gameTimer.start();
	}
	
	public void backgroundMusic() {
    	try {
 		   File file = new File("MarioPiano.wav");
 		   Clip clip = AudioSystem.getClip();
 		   clip.open(AudioSystem.getAudioInputStream(file));
 		   clip.start();
	
	
	public void playJump() {  // jumping effect sound
		  try {
		   File file = new File("JumpSoundEffect.wav");
		   Clip clip = AudioSystem.getClip();
		   clip.open(AudioSystem.getAudioInputStream(file));
		   clip.start();
		   
		  } catch (Exception e) {
		   System.err.println(e.getMessage());
		  }
		 }
	
	
    /**
     * Update.
     */
    protected void update() {
        if (isPressed(KeyCode.W)) {
	    playJump();		
            movePlayerUp();
        }

        if (playerVelocity.getY() < 10) {
            playerVelocity = playerVelocity.add(0, 1);
        }

        jumpPlayer((int)playerVelocity.getY());

    }
    
   /**
    * Animate correct sprite.
    */
   protected void animateCorrectSprite(){
    	playerSprites = new Image[2];
	   
    	if (chosenCharacterUrl == "view/resources/characters/adventurer_walk1.png"){
    		
    		playerSprites[0] = new Image(adventurer1);
    		playerSprites[1] = new Image(adventurer2);
    		animatePlayerSprites(playerSprites);
    		
    		}	
    	else if (chosenCharacterUrl == "view/resources/characters/female_walk1.png"){
    		playerSprites[0] = new Image(female1);
    		playerSprites[1] = new Image(female2);
    		animatePlayerSprites(playerSprites);
    		
    	}
    	else if (chosenCharacterUrl == "view/resources/characters/zombie_walk1.png"){
    		playerSprites[0] = new Image(zombie1);
    		playerSprites[1] = new Image(zombie2);
    		animatePlayerSprites(playerSprites);
    		
    	}
    	else if (chosenCharacterUrl == "view/resources/characters/soldier_walk1.png"){
    		playerSprites[0] = new Image(soldier1);
    		playerSprites[1] = new Image(soldier2);
    		animatePlayerSprites(playerSprites);
    		
    	}
    }
    		
    /**
     * Animate player sprites.
     *
     * @param images the images
     */
    // https://stackoverflow.com/questions/46570494/javafx-changing-the-image-of-an-imageview-using-timeline-doesnt-work		
    public void animatePlayerSprites(Image[] images) { 
            character.setImage(images[1]);
            Collection<KeyFrame> frames = timeLine.getKeyFrames();
            Duration frameGap = Duration.millis(900/moveSpeed);
            Duration frameTime = Duration.ZERO ;
            for (Image img : images) {
                frameTime = frameTime.add(frameGap);
                frames.add(new KeyFrame(frameTime, e -> character.setImage(img)));
            }
            timeLine.setCycleCount(Timeline.INDEFINITE);
            timeLine.play();
        }
    
    /**
     * Creates the game over scene.
     */
    private void createGameOverScene(){
		gameOverSubScene = new RunnerSubScene();		
		gamePane.getChildren().add(gameOverSubScene);
		gameOverSubScene.setLayoutY(80);
		gameOverSubScene.setLayoutX(1140);
		showSubScene(gameOverSubScene);
		RunnerButton menuButton = new RunnerButton("MENU");
		menuButton.setLayoutX(200);
		menuButton.setLayoutY(300);
		
		InfoLabel gameOverLabel = new InfoLabel("GAME OVER");
		gameOverLabel.setLayoutX(100);
		gameOverLabel.setLayoutY(25);
		
		finalScoreLabel = new SmallInfoLabel("SCORE : " + Integer.toString(score));
		finalScoreLabel.setLayoutX(190);
		finalScoreLabel.setLayoutY(120);
		finalScoreLabel.setPrefWidth(700);
		
		menuButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
                try {
                    writeHighScores(score);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
				menuStage.show();
				gameStage.close();


	
				}	
		});
		gameOverSubScene.getPane().getChildren().addAll(menuButton, finalScoreLabel, gameOverLabel);
    	
}
    
    
   /**
    * Check collision.
    */
   private void checkCollision(){
	   
    	if ((character.getBoundsInParent().intersects(slime1.getBoundsInParent())) || character.getBoundsInParent().intersects(slime2.getBoundsInParent())) {
    			gameTimer.stop();
    			timeLine.pause();
    			createGameOverScene();
    		
    		}
    }	
   
    
	/**
	 * Sets the new element position.
	 *
	 * @param image the new new element position
	 */
	protected void setNewElementPosition(ImageView image){
		if (image == slime1){
			image.setLayoutX(GAME_WIDTH+200);
			image.setLayoutY(((GAME_HEIGHT /4) * 3) + 38);}
		if (image == slime2){
			image.setLayoutX(GAME_WIDTH+340);
			image.setLayoutY(((GAME_HEIGHT /4) * 3) + 79);}
			
	}
		
	
	
	/**
	 * Creates the score label.
	 */
	public void createScoreLabel(){
		pointsLabel = new SmallInfoLabel("SCORE : " + Integer.toString(score));
		pointsLabel.setLayoutX(100);
		pointsLabel.setLayoutY(60);
		gamePane.getChildren().add(pointsLabel);
	}
	
	/**
	 * Creates the high score label.
	 */
	public void createHighScoreLabel(){
		pointsLabel = new SmallInfoLabel("HIGH SCORE : " + Integer.toString(highScore));
		pointsLabel.setLayoutX(100);
		pointsLabel.setLayoutY(60);
		gamePane.getChildren().add(pointsLabel);
	}
	
	/**
	 * Creates the main menu button.
	 */
	
	public void createMainMenuButton(){
		RunnerButton mainMenuButton = new RunnerButton("MENU");
		mainMenuButton.setLayoutX(900);
		mainMenuButton.setLayoutY(60);
		
		mainMenuButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				menuStage.show();
				gameStage.close();


	
				}	
		});
		
		gamePane.getChildren().add(mainMenuButton);
		
	}
	
	private void writeHighScores(int score) throws IOException {
    	try{
    		
    	
        File scoreFolder = new File("Scores");
        File scoreTxt = new File (scoreFolder + "/" + "Score.txt");
        PrintWriter writer = new PrintWriter(new FileOutputStream("/src/Scores/Score.txt", true));
        if (score > 0) {
            writer.append(score + "\n");
        }
        writer.close(); 
    } catch (Exception e){
    	e.printStackTrace();
    	
    }
    
     }
	

	/**
	 * Creates the game elements.
	 */
	protected void createGameElements(){
		
		slime1 = new ImageView();
		slime1 = new ImageView(SLIME_IMAGE);
		gamePane.getChildren().add(slime1);
		slime1.setLayoutX(GAME_WIDTH+100);
		slime1.setLayoutY(((GAME_HEIGHT /4) * 3) + 38);
		
		
		slime2 = new ImageView();
		slime2 = new ImageView(SLIME2_IMAGE);
		gamePane.getChildren().add(slime2);
		slime2.setLayoutX(GAME_WIDTH+2134);
		slime2.setLayoutY(((GAME_HEIGHT /4) * 3) + 79);
		
	}	
	
	/**
	 * Move game elements.
	 */
	protected void moveGameElements(){

		slime1.setLayoutX(slime1.getLayoutX() - moveSpeed);
		slime2.setLayoutX(slime2.getLayoutX() - moveSpeed);
		
	}
	
	/**
	 * Check if obstacles past.
	 */
	protected void checkIfObstaclesPast(){
	
			if (slime1.getLayoutX() < -100){
				setNewElementPosition(slime1);
				score++;
				createScoreLabel();
		    	if (moveSpeed <= 20){
		    		moveSpeed = (moveSpeed + 0.5);}		
			
		}	
			if (slime2.getLayoutX() < -350){
				setNewElementPosition(slime2);
				score++;
				createScoreLabel();	
			
		}	
		
	}

    
    /**
     * Checks if is pressed.
     *
     * @param key the key
     * @return true, if is pressed
     */
    protected boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }
	
	/**
	 * Jump player.
	 *
	 * @param value the value
	 */
	protected void jumpPlayer(int value){
			boolean movingDown = value > 0;

	        for (int i = 0; i < Math.abs(value); i++) {
	            for (Node platform : platforms) {
	                if (character.getBoundsInParent().intersects(platform.getBoundsInParent())) {
	                    if (movingDown) {
	                        if (character.getTranslateY() + 498 == platform.getTranslateY()) {
	                            character.setTranslateY(character.getTranslateY() - 1);
	                            canJump = true;
	                            return;
	                        }
	                    }
	                    else {
	                        if (character.getTranslateY() == platform.getTranslateY() + 100) {
	                            return;
	                        }
	                    }
	                }
	            }
	            character.setTranslateY(character.getTranslateY() + (movingDown ? 1 : -1));
	        }
	    }
			
			
	/**
	 * Creates the background.
	 */
	protected void createBackground(){
		gridPane1 = new GridPane();
		gridPane2 = new GridPane();
		gridPane3 = new GridPane();
		
		groundPane1 = new BorderPane();
		groundPane2 = new BorderPane();
		groundPane3 = new BorderPane();
		groundPane4 = new BorderPane();		
		groundPane5 = new BorderPane();
		groundPane6 = new BorderPane();	
		
		Rectangle bg = new Rectangle(GAME_WIDTH, GAME_HEIGHT, Color.POWDERBLUE);
		
		
		
		for( int i=0; i <12; i++){
			ImageView backgroundImage1 = new ImageView(BACKGROUND_IMAGE);
			ImageView backgroundImage2 = new ImageView(BACKGROUND_IMAGE);
			ImageView backgroundImage3 = new ImageView(BACKGROUND_IMAGE);
			
			GridPane.setConstraints(backgroundImage1, i % 3, i / 3);
			GridPane.setConstraints(backgroundImage2, i % 3, i / 3);
			GridPane.setConstraints(backgroundImage3, i % 3, i / 3);
			
			gridPane1.getChildren().add(backgroundImage1);
			gridPane2.getChildren().add(backgroundImage2);
			gridPane3.getChildren().add(backgroundImage3);
			
		}
		gridPane1.setLayoutX(265*3);
		gridPane2.setLayoutX(0);
		gridPane3.setLayoutX(265*6);
		
		gamePane.getChildren().addAll(bg, gridPane1, gridPane2, gridPane3);
		
		
		ImageView groundImage1 = new ImageView(GROUND_IMAGE);
		ImageView groundImage2 = new ImageView(GROUND_IMAGE);
		ImageView groundImage3 = new ImageView(GROUND_IMAGE);
		ImageView groundImage4 = new ImageView(GROUND_IMAGE);
		ImageView groundImage5 = new ImageView(GROUND_IMAGE);
		ImageView groundImage6 = new ImageView(GROUND_IMAGE);
		
		groundPane1.setTop(groundImage1);
		groundPane2.setTop(groundImage2);
		groundPane3.setTop(groundImage3);
		groundPane4.setTop(groundImage4);
		groundPane5.setTop(groundImage5);
		groundPane6.setTop(groundImage6);
		
	
		groundPane4.setLayoutY(GAME_HEIGHT - 28);
		groundPane4.setLayoutX(0);
		groundPane5.setLayoutY(GAME_HEIGHT - 28);
		groundPane5.setLayoutX(713);
		groundPane6.setLayoutY(GAME_HEIGHT - 28);
		groundPane6.setLayoutX(1426);
		groundPane1.setLayoutY(GAME_HEIGHT - 28);
		groundPane1.setLayoutX(0);
		groundPane2.setLayoutY(GAME_HEIGHT - 28);
		groundPane2.setLayoutX(713);
		groundPane3.setLayoutY(GAME_HEIGHT - 28);
		groundPane3.setLayoutX(1426);
		
		gamePane.getChildren().addAll(groundPane4, groundPane5, groundPane6,groundPane1, groundPane2, groundPane3);

	}
	
	/**
	 * Move background.
	 */
	protected void moveBackground(){
		gridPane1.setLayoutX(gridPane1.getLayoutX() - (moveSpeed / 10));
		gridPane2.setLayoutX(gridPane2.getLayoutX() - (moveSpeed / 10));
		gridPane3.setLayoutX(gridPane3.getLayoutX() - (moveSpeed / 10));
		
		if(gridPane1.getLayoutX() <= (-265*3)){
			gridPane1.setLayoutX((265*6)-10);
		
		}
		if(gridPane2.getLayoutX() <= (-265*3)){
			gridPane2.setLayoutX((265*6)-10);
		
		}
		if(gridPane3.getLayoutX() <= (-265*3)){
			gridPane3.setLayoutX((265*6)-10);
		
		}
		
	}
	
	/**
	 * Move ground.
	 */
	protected void moveGround(){
		groundPane1.setLayoutX(groundPane1.getLayoutX()-moveSpeed);
		groundPane2.setLayoutX(groundPane2.getLayoutX()-moveSpeed);
		groundPane3.setLayoutX(groundPane3.getLayoutX()-moveSpeed);
		
		if(groundPane1.getLayoutX() <= (-713)){
			groundPane1.setLayoutX((705*2) - 48);
		
		}
		if(groundPane2.getLayoutX() <= (-713)){
			groundPane2.setLayoutX((705*2) - 48);
		
		}
		if(groundPane3.getLayoutX() <= (-713)){
			groundPane3.setLayoutX((705*2) - 48);
		
		}
		
	}
	

    /**
     * Creates the platform.
     *
     * @return the node
     */
    protected Node createPlatform() {
        Rectangle entity = new Rectangle(100, 100);
        entity.setTranslateX(180);
        entity.setTranslateY(511);
        entity.setFill(Color.TRANSPARENT);
        platforms.add(entity);
        gamePane.getChildren().add(entity);
        return entity;
    }
}
