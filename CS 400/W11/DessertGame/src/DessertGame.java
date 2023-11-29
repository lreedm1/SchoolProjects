import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.geometry.Pos;

public class DessertGame extends Application {

    @Override
    public void start(final Stage stage) {
        // Step 3 & 4
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 640, 480);
        stage.setTitle("Dessert in the Desert JavaFX Game");
        
        // Step 5
        Label scoreLabel = new Label("Score: 0");
        borderPane.setTop(scoreLabel);
        BorderPane.setAlignment(scoreLabel, Pos.TOP_LEFT);

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> {
            Platform.exit();
        });
        borderPane.setBottom(exitButton);
        BorderPane.setAlignment(exitButton, Pos.BOTTOM_RIGHT);
        
        // Step 6
        Pane pane = new Pane();
        borderPane.setCenter(pane);
        BorderPane.setAlignment(pane, Pos.CENTER);

        // Step 7
        // a signle button with the label "Dessert" and seven more buttons with the label "Desert" on the pane in step 6
        Button dessertButton = new Button("Dessert");
        dessertButton.setLayoutX(100);
        dessertButton.setLayoutY(100);
        pane.getChildren().add(dessertButton);
        for (int i = 0; i < 7; i++) {
            Button desertButton = new Button("Desert");
            desertButton.setLayoutX(100 + i * 100);
            desertButton.setLayoutY(200);
            pane.getChildren().add(desertButton);
        }

        // Step 8
        /*  two private helper methods named randomizeButtonPositions that take two inputs: a java.utilRandom and an array of Button objects
         this method uses setLayoutX and setLayoutY with the x range 0-600 and the y range 0-400
         this method should be called when the program starts and after any Dessert or Desert button is pressed
        */
        randomizeButtonPositions(new java.util.Random(), new Button[] {dessertButton});
        for (int i = 0; i < 7; i++) {
            randomizeButtonPositions(new java.util.Random(), new Button[] {dessertButton});
        }

        // Step 9
        /*Add a private int field named score to your class, and initialize it to zero. Every time the
         "Dessert" button is clicked, increment this score by one before updating the text within the 
         score label to display this new score. Every time the "Desert" button is clicked, decrement 
         this score by one before updating the text within the score label to display this new score.
          You are welcome (but not required) to create helper methods to better organize this code. */
        int score = 0;
        dessertButton.setOnAction(event -> {
            updateScore(score);
            scoreLabel.setText("Score: " + score);
        });

        // Step 10
        /*You may notice that by default, any button clicked will retain 
        focus and be displayed a bit differently from the other buttons. 
        Since this makes our game a bit too easy, call the requestFocus 
        method on the "Exit" button both 1) when our game starts up, and 
        2) every time any "Dessert" or "Desert" button is clicked. 
        This should keep the Exit button in focus, and make our other buttons
        look more similar to one another. */
        exitButton.requestFocus();
        dessertButton.setOnAction(event -> {
            exitButton.requestFocus();
        });

        
        
        stage.setScene(scene);
        stage.show();
    }

    private void randomizeButtonPositions(Random random, Button[] buttons) {
        for (Button button : buttons) {
            button.setLayoutX(random.nextInt(600));
            button.setLayoutY(random.nextInt(400));
        }
    }
    
    // step 9 helper method
    private void updateScore(int score) {
        score++;
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
