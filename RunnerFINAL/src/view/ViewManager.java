package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.text.Font;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.CHARACTER;
import model.CharacterPicker;
import model.InfoLabel;
import model.RunnerButton;
import model.RunnerSubScene;
import view.GameViewManager;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewManager.
 */
public class ViewManager {
	
	/** The Constant HEIGHT. */
	private static final int HEIGHT = 760;
	
	/** The Constant WIDTH. */
	private static final int WIDTH = 1200;
	
	/** The main pane. */
	private AnchorPane mainPane;
	
	/** The main scene. */
	private Scene mainScene;
	
	/** The main stage. */
	private Stage mainStage;
	
	/** The line int. */
	public int lineInt = 0;
	
	
	/** The Constant MENU_BUTTONS_START_X. */
	private final static int MENU_BUTTONS_START_X = 100;
	
	/** The Constant MENU_BUTTONS_START_Y. */
	private final static int MENU_BUTTONS_START_Y = 150;	
	
	/** The help sub scene. */
	private RunnerSubScene helpSubScene;
	
	/** The credits sub scene. */
	private RunnerSubScene creditsSubScene;
	
	/** The scores sub scene. */
	private RunnerSubScene scoresSubScene;
	
	/** The character chooser scene. */
	private RunnerSubScene characterChooserScene;
	
	/** The scene to hide. */
	private RunnerSubScene sceneToHide;
	
	/** The score 1. */
	int score1;
	
	/** The score 2. */
	int score2;
	
	/** The score 3. */
	int score3;
	
	/** The score 4. */
	int score4;
	
	/** The score 5. */
	int score5;
			
	/** The menu buttons. */
	List<RunnerButton> menuButtons;
	
	/** The character list. */
	List<CharacterPicker> characterList;
	
	/** The chosen character. */
	private CHARACTER chosenCharacter;
	
	/**
	 * Instantiates a new view manager.
	 */
	public ViewManager(){
		menuButtons = new ArrayList<>();
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane,WIDTH,HEIGHT);
		mainStage = new Stage();
		mainStage.setResizable(false);
		mainStage.setScene(mainScene);
		createSubScenes();
		createButtons();
		createBackground();
		createLogo();	
		
	}
	
	/**
	 * Show sub scene.
	 *
	 * @param subScene the sub scene
	 */
	public void showSubScene(RunnerSubScene subScene){
		if(sceneToHide != null){
			sceneToHide.moveSubScene();
		}
		subScene.moveSubScene();
		sceneToHide = subScene;
	}
	

	
	/**
	 * Creates the high score list.
	 
	private void createHighScoreList(){
		BufferedReader b;

        try {


            b = new BufferedReader(new FileReader("/Users/jakemorrissey/Documents/CPSC219/RunnerFINAL/src/Scores/Score.txt"));
            
            String line = b.readLine();

            while (line != null) {
               lineInt = Integer.parseInt(line);
               if (lineInt > score1){
               score1 = lineInt;
               b.readLine();
               return;
               }
            }                    
            
        return;}
         catch (IOException e) {
            e.printStackTrace();
        }

    
	}
	
	
	
	
	/**
	 * Creates the sub scenes.
	 */
	private void createSubScenes(){
		
		createCreditsSubScene();
		createHelpSubScene();
		scoresHelpSubScene();
		createCharacterChooserSubScene();
			
		}
	
	/**
	 * Scores help sub scene.
	 */
	private void scoresHelpSubScene(){
		scoresSubScene = new RunnerSubScene();
		mainPane.getChildren().add(scoresSubScene);
		
		InfoLabel scoresLabel = new InfoLabel("SCORES");
		scoresLabel.setLayoutX(110);
		scoresLabel.setLayoutY(25);
		
		Label Score1 = new Label("High Scores: ");
		Label Score2 = new Label("1: " + score1);
		Label Score3 = new Label("2: " + score2);
		Label Score4 = new Label("3: "+ score3);
		Label Score5 = new Label("4: "+ score4);
		
		Score1.setFont(new Font("Verdana", 22));
		Score2.setFont(new Font("Verdana", 22));
		Score3.setFont(new Font("Verdana", 22));
		Score4.setFont(new Font("Verdana", 22));
		Score5.setFont(new Font("Verdana", 22));
		
		Score2.setLayoutX(110);
		Score2.setLayoutY(160);
		
		Score1.setLayoutX(110);
		Score1.setLayoutY(110);
		
		Score3.setLayoutX(110);
		Score3.setLayoutY(210);
		
		Score4.setLayoutX(110);
		Score4.setLayoutY(260);
		
		Score5.setLayoutX(110);
		Score5.setLayoutY(310);
		
		
		
		scoresSubScene.getPane().getChildren().addAll(scoresLabel, Score1, Score2, Score3, Score4, Score5);
		
	}
	
	/**
	 * Creates the help sub scene.
	 */
	private void createHelpSubScene(){
		helpSubScene = new RunnerSubScene();
		mainPane.getChildren().add(helpSubScene);
		
		InfoLabel helpLabel = new InfoLabel("HELP");
		helpLabel.setLayoutX(110);
		helpLabel.setLayoutY(25);
		
		Label howToPlay = new Label("Press ↑ to jump over obstacles.");
		Label howToPlay2 = new Label("Run for as long as possible to");
		Label howToPlay3 = new Label("increase your score, and set new");
		Label howToPlay4 = new Label("records");
		
		howToPlay.setFont(new Font("Verdana", 22));
		howToPlay2.setFont(new Font("Verdana", 22));
		howToPlay3.setFont(new Font("Verdana", 22));
		howToPlay4.setFont(new Font("Verdana", 22));
		
		howToPlay2.setLayoutX(110);
		howToPlay2.setLayoutY(160);
		
		howToPlay.setLayoutX(110);
		howToPlay.setLayoutY(110);
		
		howToPlay3.setLayoutX(110);
		howToPlay3.setLayoutY(210);
		
		howToPlay4.setLayoutX(110);
		howToPlay4.setLayoutY(260);
			
		helpSubScene.getPane().getChildren().addAll(helpLabel, howToPlay, howToPlay2, howToPlay3, howToPlay4);
		
	}
	
	/**
	 * Creates the credits sub scene.
	 */
	private void createCreditsSubScene(){
		creditsSubScene = new RunnerSubScene();
		mainPane.getChildren().add(creditsSubScene);
		
		InfoLabel creditsLabel = new InfoLabel("CREDITS");
		creditsLabel.setLayoutX(110);
		creditsLabel.setLayoutY(25);
		
		Label credits1 = new Label("Developed by:");
		Label credits2 = new Label("U of C CPSC 219 Group 15");
		Label credits3 = new Label("Jake M, Carlos V, Matt L, Robin S");
		Label credits4 = new Label("Special Thanks to:");
		Label credits5 = new Label("youtube.com/JavaCraving");
		
		credits1.setFont(new Font("Verdana", 22));
		credits2.setFont(new Font("Verdana", 22));
		credits3.setFont(new Font("Verdana", 22));
		credits4.setFont(new Font("Verdana", 22));
		credits5.setFont(new Font("Verdana", 22));
		
		credits1.setLayoutX(110);
		credits1.setLayoutY(160);
		
		credits2.setLayoutX(110);
		credits2.setLayoutY(110);
		
		credits3.setLayoutX(110);
		credits3.setLayoutY(210);
		
		credits4.setLayoutX(110);
		credits4.setLayoutY(290);
		
		credits5.setLayoutX(110);
		credits5.setLayoutY(340);
		
		
		creditsSubScene.getPane().getChildren().addAll(creditsLabel, credits1, credits2, credits3, credits4, credits5);
		
	}
	
	/**
	 * Creates the character chooser sub scene.
	 */
	private void createCharacterChooserSubScene(){
		characterChooserScene = new RunnerSubScene();
		mainPane.getChildren().add(characterChooserScene);
		
		InfoLabel chooseCharacterLabel = new InfoLabel("SELECT A CHARACTER");
		chooseCharacterLabel.setLayoutX(110);
		chooseCharacterLabel.setLayoutY(25);
		characterChooserScene.getPane().getChildren().add(chooseCharacterLabel);
		characterChooserScene.getPane().getChildren().add(createCharactersToChoose());
		characterChooserScene.getPane().getChildren().add(createButtonToStart());
		
		
	}
	
	/**
	 * Creates the characters to choose.
	 *
	 * @return the h box
	 */
	private HBox createCharactersToChoose(){
		HBox box = new HBox();
		box.setSpacing(20);
		characterList = new ArrayList<>();
		for(CHARACTER character : CHARACTER.values()){
			CharacterPicker characterToPick = new CharacterPicker(character);
			characterList.add(characterToPick);
			box.getChildren().add(characterToPick);
			characterToPick.setOnMouseClicked(new EventHandler<MouseEvent>(){
				
				@Override
				public void handle(MouseEvent event){
					for (CharacterPicker character : characterList){
						character.setCircleIsChosen(false);
					}
					characterToPick.setCircleIsChosen(true);
					chosenCharacter = characterToPick.getCharacter();
					
				}
			});
		}
		box.setLayoutX(100);
		box.setLayoutY(100);
		return box;
	}

	/**
	 * Creates the button to start.
	 *
	 * @return the runner button
	 */
	private RunnerButton createButtonToStart(){
		RunnerButton startButton = new RunnerButton("START");
		startButton.setLayoutX(350);
		startButton.setLayoutY(300);
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(chosenCharacter != null){
					GameViewManager gameManager = new GameViewManager();
					gameManager.createNewGame(mainStage, chosenCharacter);
				}
				
				
			}
			
		});
		
		return startButton;
				
	}
	
	/**
	 * Gets the main stage.
	 *
	 * @return the main stage
	 */
	public Stage getMainStage(){
		return mainStage;
	}
	
	/**
	 * Creates the buttons.
	 */
	public void createButtons(){
		createStartButton();
		createScoresButton();
		createHelpButton();
		createCreditsButton();
		createExitButton();
	
	}

	/**
	 * Adds the menu button.
	 *
	 * @param button the button
	 */
	private void addMenuButton(RunnerButton button){
		button.setLayoutX(MENU_BUTTONS_START_X);
		button.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size() * 100);
		menuButtons.add(button);
		mainPane.getChildren().add(button);
	}

	/**
	 * Creates the start button.
	 */
	private void createStartButton(){
		RunnerButton startButton = new RunnerButton("PLAY");
		addMenuButton(startButton);
		startButton.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event){
				showSubScene(characterChooserScene);
			}
		});
	}
	
	/**
	 * Creates the scores button.
	 */
	private void createScoresButton(){
		RunnerButton scoresButton = new RunnerButton("SCORES");
		addMenuButton(scoresButton);
		
		scoresButton.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event){
				showSubScene(scoresSubScene);
			}
		});
	}
	
	/**
	 * Creates the credits button.
	 */
	private void createCreditsButton(){
		RunnerButton creditsButton = new RunnerButton("CREDITS");
		addMenuButton(creditsButton);
		
		creditsButton.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event){
				showSubScene(creditsSubScene);
			}
		});
		
	}
	
	/**
	 * Creates the help button.
	 */
	private void createHelpButton(){
		RunnerButton helpButton = new RunnerButton("HELP");
		addMenuButton(helpButton);
		
		helpButton.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event){
				showSubScene(helpSubScene);
			}
		});
	}
	
	/**
	 * Creates the exit button.
	 */
	private void createExitButton(){
		RunnerButton exitButton = new RunnerButton("EXIT");
		addMenuButton(exitButton);
		
		exitButton.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event){
				mainStage.close();
			}
		});
	}
	
	/**
	 * Creates the logo.
	 */
	private void createLogo(){
		ImageView logo = new ImageView("view/resources/logo.png");
		logo.setLayoutX(275);
		logo.setLayoutY(50);
		
		logo.setOnMouseEntered(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(new DropShadow());		
			}	
		});
		logo.setOnMouseExited(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(null);		
			}	
		});
		mainPane.getChildren().add(logo);
	}
	
	/**
	 * Creates the background.
	 */
	private void createBackground(){
		Image backgroundImage = new Image("view/resources/background.png", 256, 256, false, true);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null );
		mainPane.setBackground(new Background(background));
	}
	
}
