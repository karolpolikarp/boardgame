package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Board extends Pane {

    private int boardWidth = 9;
    private int boardHeight = 9;
    List columnList = new LinkedList();
    List rowList = new LinkedList();


    private Rectangle[][] board;


    public Board() {

        board = new Rectangle[boardWidth][boardHeight];

        for (int x = 0; x < boardWidth; x++) {
            for (int y = 0; y < boardHeight; y++) {
                board[x][y] = new Rectangle();
                board[x][y].setX(x * 50);
                board[x][y].setY(y * 50);
                board[x][y].setWidth(50);
                board[x][y].setHeight(50);
                board[x][y].setStroke(Color.BLACK);
                board[x][y].setStrokeType(StrokeType.OUTSIDE);
                board[x][y].setStrokeWidth(1);
            }
        }
        for (int x = 0; x < boardWidth; x++) {
            for (int y = 0; y < boardHeight;y++) {
                if (((x == 0 && y == 8))) {
                    board[x][y].setFill(Color.GREEN);
                    columnList.add(x);
                    rowList.add(y);

                } else if((((x == 8 && y == 0)))){
                    board[x][y].setFill(Color.RED);
                    columnList.add(y);
                    rowList.add(y);

                } else if ((((y % 2 == 0) || ((x == 8 && y == 3) || (x == 8 && y == 7))) || ((x == 0 && y == 1) || (x == 0 && y == 5)))) {
                    board[x][y].setFill(Color.WHEAT);
                    columnList.add(x);
                    rowList.add(y);

                } else
                    board[x][y].setFill(Color.DEEPSKYBLUE);
            }
        }
        System.out.println("Rozmiar listy to: "+ columnList.size()+rowList.size());
        System.out.println("COORD X:" + columnList);
        System.out.println("COORD Y:" + rowList);
    }
    public void placeboard(final int i, final int y){
        getChildren().add(board[i][y]);
    }
}
