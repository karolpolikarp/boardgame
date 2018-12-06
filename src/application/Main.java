package application;

import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Board board = new Board();

            GridPane grid = new GridPane();

//            for (int x = 0; x < 9; x++) {
//                for (int y = 0; y < 9; y++) {
//                    board.placeboard(x, y);
//                }
//            }
            for (BoardField field:board.getFields()) {

                grid.add(field.getShapeX(), field.getX(), field.getY());
            }

            Scene scene = new Scene(grid, (board.boardX * 50 + board.boardY * 2), 600);
            Button button = new Button("Click Me");




            primaryStage.setTitle("Roll and move!");
            scene.setFill(Color.TRANSPARENT);
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