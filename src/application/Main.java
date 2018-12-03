package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.util.Random;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Board board = new Board();

            GridPane grid = new GridPane();

            for (int i = 0; i < 9; i++) {
                for (int y = 0; y < 9; y++) {
                    board.placeboard(i, y);
                }
            }

            grid.add(board, 0, 0);


            Scene scene = new Scene(grid, 451, 600);
            Button button = new Button("Click Me");

            primaryStage.setTitle("Roll and move!");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}