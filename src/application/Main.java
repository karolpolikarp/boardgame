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
        diceSetter();
        boardRepaint();

        stage.setScene(ns1);
        stage.show();
        diceAmt.setText("You've rolled a " + diceRolled);
//        System.out.println("You've rolled a " + diceSetter() + ".");
    }

    private void boardRepaint() {
        grid = new GridPane();
        blankBoardRepaint();
        results.getChildren().addAll(grid, hbox1);
        board.getFields().get(board.getPlayerPosition()).setUserOn(true);
//        //wysw fields
//        //wysl gracza
////        setSpecialTiles(); zdefiniowane w polu
//        backgroundRepaint();
    }

    private void blankBoardRepaint() {
        backgroundBoard.generateBackgroundFields(); /// generuje drugi board pod pierszym
        board.generateBoard();
        board.getFields().get(board.getPlayerPosition()).setUserOn(true);
        System.out.println(board.getFields());
        System.out.println(backgroundBoard.getBackgroundFields()); /// generuje drugi board pod pierszym w gridzie
        for (BoardField backgroundFields : backgroundBoard.getBackgroundFields()) {
            grid.add(backgroundFields.getShapeX(), backgroundFields.getX(), backgroundFields.getY());
        }
        for (BoardField fields : board.getFields()) {
            grid.add(fields.getShapeX(), fields.getX(), fields.getY());
        }
        for (BoardField blankFields : board.getBlankFields()) {
            grid.add(blankFields.getShapeX(),  blankFields.getX(),  blankFields.getY());
        }
    }
    private void backgroundRepaint() {
        for (BoardField backgroundField : board.getBackgroundFields()) {
            grid.add(backgroundField.getShapeX(), backgroundField.getX(), backgroundField.getY());
        }
    }
////    private void setSpecialTiles() {
////        board.getFields().get(5).setSpecialTile(true);
////        board.getFields().get(10).setSpecialTile(true);
////        board.getFields().get(22).setSpecialTile(true);
////        board.getFields().get(35).setSpecialTile(true);
////        board.getFields().get(43).setSpecialTile(true);
//    }

//    backgruound tiles to zle sa to sa stare blankftiles

//    trzeba zrobi cala plasnze w petli wheat
//
//    lub sprawic aby kolo wyswietlalo sie na fiedldzie
//            a  nie tworzoylo nowy rectanlgle i tam dawalo kolo pomysll
}
