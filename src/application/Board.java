package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;

public class Board extends Pane {

    public int boardX = 9;
    public int boardY = 9;

    private List<BoardField> fields = new LinkedList<>();
    private List playableFields = new LinkedList<>();

    Dice dice = new Dice(6);
    int diceroll = dice.roll();


    public List<BoardField> getFields() {
        return fields;
    }

    public Board() {
//
//        fields.add(new BoardField(0,0, Color.BLACK));
//        fields.add(new BoardField(0,1, Color.BLUE));
//        fields.add(new BoardField(1,1, Color.RED));
//        fields.add(new BoardField(2,1, Color.YELLOW));
//        fields.get(3).setUserOn(true);

        for (int x = 0; x < boardX; x++) {
            for (int y = 0; y < boardY; y++) {
                if (((x == 0 && y == 0))) {
                    fields.add(new BoardField(x, y, Color.GREEN));
                    playableFields.add(new BoardField(x,y, Color.GREEN));
                } else if((((x == 8 && y == 8)))){
                    fields.add(new BoardField(x, y, Color.RED));
                    playableFields.add(new BoardField(x,y, Color.RED));
                } else if ((((x % 2 == 0) || ((x == 1 && y == 8) || (x == 3 && y == 0))) || ((x == 5 && y == 8) || (x == 7 && y == 0)))) {
                    fields.add(new BoardField(x, y, Color.WHEAT));
                    playableFields.add(new BoardField(x,y, Color.WHEAT));
                } else {
                    fields.add(new BoardField(x, y, Color.DEEPSKYBLUE));
                }
            }
        }

        fields.get(diceroll).setUserOn(true);
        System.out.println("You've rolled a " + diceroll + ".");
        System.out.println(playableFields.size());

        for ( int o = 0; o < playableFields.size(); o++) {
            System.out.println(o + 1 + " " + playableFields.get(o));
        }


//        fields.get(0).setUserOn(true);
//        fields.get(1).setUserOn(true);
//        fields.get(2).setUserOn(true);
//        fields.get(5).setUserOn(true);
//        fields.get(9).setUserOn(true);
//       /// board = new Rectangle[boardWidth][boardHeight];
//
//        for (int x = 0; x < boardWidth; x++) {
//            for (int y = 0; y < boardHeight; y++) {
//                board[x][y] = new Rectangle();
//                board[x][y].setX(x * 50);
//                board[x][y].setY(y * 50);
//                board[x][y].setWidth(50);
//                board[x][y].setHeight(50);
//                board[x][y].setStroke(Color.BLACK);
//                board[x][y].setStrokeType(StrokeType.OUTSIDE);
//                board[x][y].setStrokeWidth(1);
//            }
//        }
//        for (int x = 0; x < boardWidth; x++) {
//            for (int y = 0; y < boardHeight;y++) {
//                if (((x == 0 && y == 8))) {
//                    board[x][y].setFill(Color.GREEN);
//                    columnList.add(x);
//                    rowList.add(y);
//
//                } else if((((x == 8 && y == 0)))){
//                    board[x][y].setFill(Color.RED);
//                    columnList.add(y);
//                    rowList.add(y);
//
//                } else if ((((y % 2 == 0) || ((x == 8 && y == 3) || (x == 8 && y == 7))) || ((x == 0 && y == 1) || (x == 0 && y == 5)))) {
//                    board[x][y].setFill(Color.WHEAT);
//                    columnList.add(x);
//                    rowList.add(y);
//
//                } else
//                    board[x][y].setFill(Color.DEEPSKYBLUE);
//            }
//        }
//        System.out.println("Rozmiar list to: "+ columnList.size()+ " x " +rowList.size());
//        System.out.println("COORD X:" + columnList);
////        System.out.println("COORD Y:" + rowList);
////    }
//    public void placeboard(final int x, final int y){
//        getChildren().add(board[x][y]);
    }
}
