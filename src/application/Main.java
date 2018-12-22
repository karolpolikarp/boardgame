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

    private Button roll, setGame, newGame;
    private Label diceAmt;
    private Board board;
    private Stage stage;
    private GridPane grid;
    private VBox results;
    private HBox hbox1;
    private int diceRolled;
    boolean alreadyRolled = false;
    Dice dice = new Dice(6);

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
        });

        setGame = new Button();
        setGame.setText("SET GAME");
        setGame.setOnAction(e -> {
        });

        newGame = new Button();
        newGame.setText("NEW GAME");
        newGame.setOnAction(e -> {
        });

        diceAmt = new Label();

        hbox1 = new HBox();
        hbox1.getChildren().addAll(newGame, setGame, roll, diceAmt);
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
    private void diceSetter() {
//        if (!alreadyRolled) {
//        board.getFields().get(board.getPlayerPosition()).setUserOn(false);
        diceRolled = dice.roll();
        board.setPlayerPosition(board.getPlayerPosition()+ diceRolled);
//        board.getFields().get(board.getPlayerPosition()).setUserOn(true); w boardrepaint

//            alreadyRolled = true;
//        } else {
////            diceRolled = dice.roll() + diceRolled;
//            board.getFields().get(diceRolled).setUserOn(true);
//        }
//        alreadyRolled = true;
//        } else {
//            diceRolled = dice.roll();
//            board.getFields().get(diceRolled).setUserOn(true);
//            alreadyRolled = true;
//            return diceRolled;
//        }
    }

    private void displayDiceRoll() {
        BorderPane border1 = new BorderPane();
        results = new VBox(10);
        border1.setCenter(results);
        Scene ns1 = new Scene(border1, (board.boardX * 50 + board.boardY * 2), 525);
        boardRepaint();
        diceSetter();
        stage.setScene(ns1);
        stage.show();
        diceAmt.setText("You've rolled a " + diceRolled);
//        System.out.println("You've rolled a " + diceSetter() + ".");
    }

    private void boardRepaint() {
        grid = new GridPane();
        blankBoardRepaint();
        //wysw fields
        //wysl gracza
//        setSpecialTiles(); zdefiniowane w polu
        backgroundRepaint();

        for (BoardField field : board.getFields()) {
            grid.add(field.getShapeX(), field.getX(), field.getY());
        }
        results.getChildren().addAll(grid, hbox1);
    }

    private void blankBoardRepaint() {
        for (BoardField blankField : board.getBlankFields()) {
            grid.add(blankField.getShapeX(), blankField.getX(), blankField.getY());
        }
    }
    private void backgroundRepaint() {
        for (BoardField backgroundField : board.getBackgroundFields()) {
            grid.add(backgroundField.getShapeX(), backgroundField.getX(), backgroundField.getY());
        }
    }
    private void setSpecialTiles() {
        board.getFields().get(5).setSpecialTile(true);
        board.getFields().get(10).setSpecialTile(true);
        board.getFields().get(22).setSpecialTile(true);
        board.getFields().get(35).setSpecialTile(true);
        board.getFields().get(43).setSpecialTile(true);
    }
}
