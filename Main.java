package mainPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    private HashMap<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>();

    private ArrayList<Node> platforms = new ArrayList<Node>();
    private ArrayList<Node> obstacles = new ArrayList<Node>();
    
	int score = 0;
	Thread thread;
	int threadTime = 500;
	int moveSpeed = 7;

    private Pane appRoot = new Pane();
    private Pane gameRoot = new Pane();
    private Pane uiRoot = new Pane();
    
    final static String OBSTACLE_IMAGE = "imagesPackage/obstacle.png";
    private ImageView[] hazards;
    
    private Node player;
    private Node obstacle;
    private Point2D playerVelocity = new Point2D(0, 0);
    private boolean canJump = true;

    private int levelWidth;
    
    public Main(){
    	thread = new Thread();
    }
	public void startGame() {
		thread.start();
	}
    
    private boolean dialogEvent = false, running = true;

    private void initContent() {
        Rectangle bg = new Rectangle(1280, 720);

        levelWidth = LevelData.LEVEL1[0].length() * 60;

        for (int i = 0; i < LevelData.LEVEL1.length; i++) {
            String line = LevelData.LEVEL1[i];
            for (int j = 0; j < line.length(); j++) {
                switch (line.charAt(j)) {
                    case '0':
                        break;
                    case '1':
                        Node platform = createEntity(j*60, i*60, 60, 60, Color.GREEN);
                        platforms.add(platform);
                        break;
                }
            }
        }
        startGame();
        obstacle = createEntity(700, 600, 60, 60, Color.GOLD);



        player = createEntity(100, 600, 40, 40, Color.BLUE);

        player.translateXProperty().addListener((obs, old, newValue) -> {
            int offset = newValue.intValue();

            if (offset > 640 && offset < levelWidth - 640) {
                gameRoot.setLayoutX(-(offset - 640));
            }
        });

        appRoot.getChildren().addAll(bg, gameRoot, uiRoot);
    }

    private void update() {
        if (isPressed(KeyCode.W) && player.getTranslateY() >= 5) {
            jumpPlayer();
        }

        if (playerVelocity.getY() < 10) {
            playerVelocity = playerVelocity.add(0, 1);
        }

        movePlayerY((int)playerVelocity.getY());

        for (Node obstacle : obstacles) {
            if (player.getBoundsInParent().intersects(obstacle.getBoundsInParent())) {
                obstacle.getProperties().put("alive", false);
                dialogEvent = true;
                running = false;
            }
        }

        for (Iterator<Node> it = obstacles.iterator(); it.hasNext(); ) {
            Node obstacle = it.next();
            if (!(Boolean)obstacle.getProperties().get("alive")) {
                it.remove();
                gameRoot.getChildren().remove(obstacle);
            }
        }
    }

    private void checkObstaclePosition(){
    	if ((obstacle.getLayoutX() < (-750))){
    		resetObstaclePosition();
    	}
    }
    
    private void resetObstaclePosition(){
    	obstacle.setLayoutX(740);
    	if (moveSpeed <=20){
    		moveSpeed++;}
    	
    }
    
    private void moveObstacle() {
    	obstacle.setLayoutX(obstacle.getLayoutX() - moveSpeed);
    }

    private void movePlayerY(int value) {
        boolean movingDown = value > 0;

        for (int i = 0; i < Math.abs(value); i++) {
            for (Node platform : platforms) {
                if (player.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    if (movingDown) {
                        if (player.getTranslateY() + 40 == platform.getTranslateY()) {
                            player.setTranslateY(player.getTranslateY() - 1);
                            canJump = true;
                            return;
                        }
                    }
                    else {
                        if (player.getTranslateY() == platform.getTranslateY() + 60) {
                            return;
                        }
                    }
                }
            }
            player.setTranslateY(player.getTranslateY() + (movingDown ? 1 : -1));
        }
    }

    private void checkCollision(){
    	if (player.getLayoutX() + 40 <= obstacle.getLayoutX()  && player.getLayoutX() + 40 >= obstacle.getLayoutX() - 50){
    		dialogEvent = true;
    		running = false;
    	}
    }
    
    private void jumpPlayer() {
        if (canJump) {
            playerVelocity = playerVelocity.add(0, -30);
            canJump = false;
        }
    }

    private Node createEntity(int x, int y, int w, int h, Color color) {
        Rectangle entity = new Rectangle(w, h);
        entity.setTranslateX(x);
        entity.setTranslateY(y);
        entity.setFill(color);
        entity.getProperties().put("alive", true);

        gameRoot.getChildren().add(entity);
        return entity;
    }

    private boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }

    public void obstacleMovement(){

    	while(true) {		
    		if (threadTime >=150){
    			threadTime --;}
    		try {
    			Thread.sleep(score);
    		} catch (InterruptedException e) {
    			e.printStackTrace();	
    		}
    		score++;
    		moveObstacle();
    		
    	}
    	
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initContent();

        Scene scene = new Scene(appRoot);
        scene.setOnKeyPressed(event -> keys.put(event.getCode(), true));
        scene.setOnKeyReleased(event -> keys.put(event.getCode(), false));
        primaryStage.setTitle("Runner");
        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (running) {
                    update();
                    moveObstacle();
                    checkObstaclePosition();
                }

                if (dialogEvent) {
                    dialogEvent = false;
                    keys.keySet().forEach(key -> keys.put(key, false));

                    GameDialog dialog = new GameDialog();
                    dialog.setOnCloseRequest(event -> {
                        if (dialog.isCorrect()) {
                            System.out.println("Correct");
                        }
                        else {
                            System.out.println("Wrong");
                        }

                        running = true;
                    });
                    dialog.open();
                }
            }
        };
        timer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}