package application;

import application.fields.BoardField;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Modality;


public class Main extends Application {

    private Button roll, rules, newGame;
    private Label diceAmt;
    private Board board;
    private Player player;
    private BackgroundBoard backgroundBoard;
    private Stage stage;
    private GridPane grid;
    private VBox results;
    private HBox hbox1;
    private int diceRolled;
    private int computerRolled;
    private boolean end = false;
    Dice dice = new Dice(6);


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        stage = primaryStage;
        stage.setResizable(false);
        primaryStage.setTitle("Roll and move!");
        board = new Board();
        backgroundBoard = new BackgroundBoard();

        roll = new Button();
        roll.setText("ROLL");
        roll.setOnAction(e -> {
            displayDiceRoll();
        });

        rules = new Button();
        rules.setText("RULES");
        rules.setOnAction(event -> {
            displayRules();
        });

        newGame = new Button();
        newGame.setText("NEW GAME");
        newGame.setOnAction(e -> {
                setNewGame();
        });

        diceAmt = new Label();

        hbox1 = new HBox();
        hbox1.getChildren().addAll(newGame, rules, roll, diceAmt);
        hbox1.setAlignment(Pos.CENTER);
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
        computerRolled = dice.roll();
        if (board.getPlayerPosition() <= board.getMaxPosition()) {
            board.setPlayerPosition(board.getPlayerPosition() + diceRolled);
        } else {
            board.setPlayerPosition(48);
            end = true;
        }
        if (board.getComputerPosition() <= board.getMaxPosition()) {
            board.setComputerPosition(board.getComputerPosition() + computerRolled);
        } else {
            board.setComputerPosition(48);
            end = true;
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
        diceAmt.setText("You've rolled a " + diceRolled + "." + "\n" + "Computer rolled a " + computerRolled + ".");
        if (board.getPlayerPosition() >= board.getMaxPosition()) {
            diceAmt.setText("Congratulations, you've won!");
        }
        if (board.getComputerPosition() >= board.getMaxPosition()) {
            diceAmt.setText("Computer won," + "\n" + "good luck next time!");
        }
        if (board.getComputerPosition() >= board.getMaxPosition() && board.getPlayerPosition() >= board.getMaxPosition()){
            diceAmt.setText("Wow, it's a draw!");
        }
        System.out.println("You've rolled a " + diceRolled + ".");
        System.out.println("Computer rolled a " + computerRolled + ".");
    }

    private void boardRepaint() {
        board.getFields().clear();
        board.getBlankFields().clear();
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
        board.getFields().get(board.getComputerPosition()).setComputerOn(true);
        for (BoardField backgroundFields : backgroundBoard.getBackgroundFields()) {
            grid.add(backgroundFields.getShapeX(), backgroundFields.getX(), backgroundFields.getY());
        }
        for (BoardField fields : board.getFields()) {
            grid.add(fields.getShapeX(), fields.getX(), fields.getY());
        }
        for (BoardField blankFields : board.getBlankFields()) {
            grid.add(blankFields.getShapeX(), blankFields.getX(), blankFields.getY());
        }
        for (BoardField fields : board.getFields()) {
            grid.add(fields.getShapeY(), fields.getX(), fields.getY());
        }
    }
    private void displayPlayers() {
        board.getFields().get(board.getPlayerPosition()).setUserOn(true);
        board.getFields().get(board.getComputerPosition()).setComputerOn(true);
    }
    private void setNewGame() {
        BorderPane border1 = new BorderPane();
        results = new VBox(10);
        border1.setCenter(results);
        board.ng();
        boardRepaint();
        Scene scene = new Scene(border1, (board.boardX * 50 + board.boardY * 2), 525);
        stage.setScene(scene);
        stage.show();
    }
    private void displayRules() {
        Label playerLabel = new Label("Indicates player's position on board ");
        Label computerLabel = new Label("Indicates computer's position on board ");
        Label twoPlayersLabel = new Label("Indicates player's and computer's position" + "\n" + "on board in case they are on the same field");
        Label specialTileLabel = new Label("These are special fields, rolling onto these" + "\n" + "will either take you up to 3 fields behind or forward");
        Label blankTileLabel = new Label("These are unreachable blank tiles");
        Label generalRulesLabel = new Label("Basically the purpose of this game is to reach" + "\n" + "the last field (colored RED) before your opponent does so." + "\n" + "Use the ROLL button located underneath the board" + "\n" + "to roll the dice and move your player.");


        Shape twoPlayers = new Circle(25, Color.YELLOWGREEN);
        Shape playerShape = new Circle(25, Color.BLUE);
        Shape computerShape = new Circle(25, Color.YELLOW);
        Shape specialTile = new Rectangle(50,50, Color.PURPLE);
        Shape blankTile = new Rectangle(50,50, Color.DEEPSKYBLUE);

        AnchorPane rulesLayout = new AnchorPane();
        rulesLayout.getChildren().addAll(twoPlayers, playerShape, computerShape, specialTile, blankTile, playerLabel,
                computerLabel, twoPlayersLabel, specialTileLabel, blankTileLabel, generalRulesLabel);

        rulesLayout.setTopAnchor(playerShape, 5.0);
        rulesLayout.setLeftAnchor(playerShape,1.0);
        rulesLayout.setTopAnchor(computerShape, 60.0);
        rulesLayout.setLeftAnchor(computerShape,1.0);
        rulesLayout.setTopAnchor(twoPlayers, 115.0);
        rulesLayout.setLeftAnchor(twoPlayers,1.0);
        rulesLayout.setTopAnchor(specialTile, 170.0);
        rulesLayout.setLeftAnchor(specialTile,1.0);
        rulesLayout.setTopAnchor(blankTile, 225.0);
        rulesLayout.setLeftAnchor(blankTile,1.0);

        rulesLayout.setTopAnchor(playerLabel, 20.0);
        rulesLayout.setLeftAnchor(playerLabel,60.0);
        rulesLayout.setTopAnchor(computerLabel, 72.5);
        rulesLayout.setLeftAnchor(computerLabel,60.0);
        rulesLayout.setTopAnchor(twoPlayersLabel, 122.5);
        rulesLayout.setLeftAnchor(twoPlayersLabel,60.0);
        rulesLayout.setTopAnchor(specialTileLabel, 180.0);
        rulesLayout.setLeftAnchor(specialTileLabel,60.0);
        rulesLayout.setTopAnchor(blankTileLabel, 240.0);
        rulesLayout.setLeftAnchor(blankTileLabel,60.0);
        rulesLayout.setTopAnchor(generalRulesLabel,285.0);
        rulesLayout.setLeftAnchor(generalRulesLabel,27.5);

        Scene secondScene = new Scene(rulesLayout, 400, 360);

        Stage rulesWindow = new Stage();
        rulesWindow.setTitle("Rules - Roll and move!");
        rulesWindow.setScene(secondScene);
        rulesWindow.initModality(Modality.WINDOW_MODAL);
        rulesWindow.initOwner(stage);
        rulesWindow.centerOnScreen();
        rulesWindow.setResizable(false);

        rulesWindow.show();
    }
}
