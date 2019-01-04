package application;

import application.fields.*;

import java.util.LinkedList;
import java.util.List;

public class BackgroundBoard extends Board {

    private List<BoardField> backgroundFields = new LinkedList<>();
    public List<BoardField> getBackgroundFields() {
        return backgroundFields;
    }

    public int boardX = 9;
    public int boardY = 9;

    public void generateBackgroundBoard(){
        generateBackgroundFields();
        generateBgFinishField();
        generateBgStartField();
    }
    public void generateBackgroundFields() {
        for (int x = 0; x < boardX; x++) {
            for (int y = 0; y < boardY; y++) {
                BoardField bf = new BackgroundField(x, y);
                backgroundFields.add(bf);
            }
        }
    }
    public void generateBgStartField() {
        BoardField bgStartField = new StartField(0,0);
        backgroundFields.remove(0);
        backgroundFields.add(0, bgStartField);
    }
    public void generateBgFinishField() {
        BoardField bgFinishField = new FinishField(8,8);
        backgroundFields.remove(80);
        backgroundFields.add(80, bgFinishField);
    }
}