package application;

import application.fields.BoardField;
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

import java.awt.*;


public class Main extends Application {

    private Button roll, setGame, newGame;
    private Label diceAmt;
    private Board board;
    private BackgroundBoard backgroundBoard;
    private Stage stage;
    private GridPane grid;
    private VBox results;
    private HBox hbox1;
    private int diceRolled;
    Dice dice = new Dice(6);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        primaryStage.setTitle("Roll and move!");
        board = new Board();
        backgroundBoard = new BackgroundBoard();

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

        Scene scene = new Scene(border1, (board.boardX * 50 + board.boardY * 2), 525);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void diceSetter() {
        diceRolled = dice.roll();
        if (board.getPlayerPosition() < board.getMaxPlayerPosition()) {
            board.setPlayerPosition(board.getPlayerPosition() + diceRolled);
        } else {
            board.setPlayerPosition(48);
        }
        if (board.getComputerPosition() < board.getMaxPlayerPosition()) {
            board.setComputerPosition(board.getComputerPosition() + dice.roll());
        } else {
            board.setComputerPosition(48);
        }
    }
    private void displayDiceRoll() {
        diceSetter();
        BorderPane border1 = new BorderPane();
        results = new VBox(10);
        border1.setCenter(results);
        Scene ns1 = new Scene(border1, (board.boardX * 50 + board.boardY * 2), 525);
        boardRepaint();

        stage.setScene(ns1);
        stage.show();
        diceAmt.setText("You've rolled a " + diceRolled);
        System.out.println("You've rolled a " + diceRolled + ".");
    }

    private void boardRepaint() {
        board.getFields().clear();
        board.getBackgroundFields().clear();
        backgroundBoard.getBackgroundFields().clear();
        board.getBlankFields().clear();

        grid = new GridPane();
        fieldsGenerator();
        results.getChildren().addAll(grid, hbox1);
        displayPlayers();
    }
    private void fieldsGenerator() {
        backgroundBoard.generateBackgroundBoard();
        board.generateBoard();
        board.getFields().get(board.getPlayerPosition()).setUserOn(true);
        board.getFields().get(board.getComputerPosition()).setUserOn(true);
        System.out.println(board.getFields());
        System.out.println(backgroundBoard.getBackgroundFields());
        for (BoardField backgroundFields : backgroundBoard.getBackgroundFields()) {
            grid.add(backgroundFields.getShapeX(), backgroundFields.getX(), backgroundFields.getY());
        }
        for (BoardField fields : board.getFields()) {
            grid.add(fields.getShapeX(), fields.getX(), fields.getY());
        }
        for (BoardField blankFields : board.getBlankFields()) {
            grid.add(blankFields.getShapeX(), blankFields.getX(), blankFields.getY());
        }
//        for (BoardField fields :board.getFields()){
//            grid.add(fields.getShapeY(), fields.getX(), fields.getY());
//        }
    }
    private void displayPlayers(){
        board.getFields().get(board.getPlayerPosition()).setUserOn(true);
        board.getFields().get(board.getComputerPosition()).setUserOn(true);
    }
}
