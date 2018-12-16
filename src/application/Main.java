package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;


public class Main extends Application {

    private Button roll, setGame, newGame, okButton;
    private Scene diceScene;
    private Board board;
    private Stage stage;
    private GridPane grid;
    private VBox results;
    private HBox hbox1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        primaryStage.setTitle("Roll and move!");
        board = new Board();

        roll = new Button();
        roll.setText("ROLL");
        roll.setOnAction(e -> {
            displayDiceRoll();
//            board.diceSetter();
        });

        setGame = new Button();
        setGame.setText("SET GAME");
        setGame.setOnAction(e -> {
        });

        newGame = new Button();
        newGame.setText("NEW GAME");
        newGame.setOnAction(e -> {
        });

        hbox1 = new HBox();
        hbox1.getChildren().addAll(newGame, setGame, roll);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.setPadding(new Insets(2, 2, 2, 2));
        hbox1.setSpacing(15);

        BorderPane border1 = new BorderPane();
        results = new VBox(10);
        border1.setCenter(results);
        boardRepaint();
        Scene ns = new Scene(border1, (board.boardX * 50 + board.boardY * 2), 525);

        primaryStage.setScene(ns);
        primaryStage.show();

    }
    private void displayDiceRoll () { //jak naprawic ten przycisk
        board.diceSetter();
        stage.show();
//        int diceRollAmt = board.getDiceRolled();
//        Stage diceRoll = new Stage();
//
//        diceRoll.setTitle("Dice Roll");
//        System.out.println("You've rolled a " + diceRollAmt + ".");
//        Label diceAmt = new Label();
//        diceAmt.setText("You've rolled a " + diceRollAmt);
//        okButton = new Button("OK");
//
//        okButton.setOnAction(e -> diceRoll.close());
//
//        VBox diceRollBox = new VBox(5);
//        diceRollBox.getChildren().addAll(diceAmt, okButton);
//        diceRollBox.setAlignment(Pos.CENTER);
//        diceRollBox.setPadding(new Insets(5, 5, 5, 5));
//
//        diceScene = new Scene(diceRollBox);
//        diceRoll.setScene(diceScene);
//        diceRoll.sizeToScene();
//        diceRoll.showAndWait();
    }
    private void boardRepaint(){
        grid = new GridPane();
        for (BoardField field : board.getFields()) {

            grid.add(field.getShapeX(), field.getX(), field.getY());
        }
        results.getChildren().addAll(grid, hbox1);
    }

}
