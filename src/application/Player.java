package application;

import application.fields.BoardField;

public class Player {

    Board board;
    BoardField boardField;
    Dice dice;

    private String playerName;
    private int x;
    private int y;
    private int nextX;

    private int nextY;
    private int prevX;
    private int prevY;
}