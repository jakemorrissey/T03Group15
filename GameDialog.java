package mainPackage;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GameDialog extends Stage {

    private Text textGameOver = new Text();
    private TextField fieldAnswer = new TextField();
    private Text textActualAnswer = new Text();

    private boolean correct = false;

    public GameDialog() {
        Button btnSubmit = new Button("New Game");
        btnSubmit.setOnAction(event -> {
        	close();
        });

        VBox vbox = new VBox(10, textGameOver, fieldAnswer, textActualAnswer, btnSubmit);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox);

        setScene(scene);
        initModality(Modality.APPLICATION_MODAL);
    }

    public void open() {
        textGameOver.setText("Game Over");

        show();
    }

    public boolean isCorrect() {
        return correct;
    }
}