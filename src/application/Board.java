package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;

public class Board extends Pane {

    public int boardX = 9;
    public int boardY = 9;

    private List<BoardField> fields = new LinkedList<>();
    private int diceRolled;

    public List getPlayableFields() {
        return playableFields;
    }

    public void setPlayableFields(List playableFields) {
        this.playableFields = playableFields;
    }

    Dice dice = new Dice(6);

    private List playableFields = new LinkedList<>();


    public List<BoardField> getFields() {
        return fields;
    }
    public void diceSetter(){
        diceRolled = dice.roll();
        fields.get(diceRolled).setUserOn(true);
    }
    public Board() {

        for (int x = 0; x < boardX; x++) { //przemodelowanie petli (zrezygnowanie z petli, recznie)
            for (int y = 0; y < boardY; y++) {
                if (((x == 0 && y == 0))) {
                    BoardField bf = new BoardField(x, y, Color.GREEN, 0, 1, -1, -1);
                    fields.add(bf);
                    playableFields.add(bf);
                } else if((((x == 8 && y == 8)))){
                    BoardField bf = new BoardField(x, y, Color.RED, -1, -1, -1, -1);
                    fields.add(bf);
                    playableFields.add(bf);
                } else if ((((x % 2 == 0) || ((x == 1 && y == 8) || (x == 3 && y == 0))) || ((x == 5 && y == 8) || (x == 7 && y == 0)))) {
                    BoardField bf = new BoardField(x, y, Color.WHEAT, -1, -1, -1, -1);
                    fields.add(bf);
                    playableFields.add(bf);
                } else {
                    BoardField bf = new BoardField(x, y, Color.DEEPSKYBLUE, -1, -1, -1, -1);
                    fields.add(bf);
                }
            }
        }
            fields.get(5).setSpecialTile(true);  //jak to zmienić na playablefields oraz ułożyc kolejność pól względem planszy
            fields.get(22).setSpecialTile(true);
            fields.get(40).setSpecialTile(true);
            fields.get(60).setSpecialTile(true);
            fields.get(75).setSpecialTile(true);

            //diceSetter();




        for ( int o = 0; o < playableFields.size(); o++) {
            System.out.println(o + 1 + " " + playableFields.get(o));
        }
    }

    public int getDiceRolled() {
        return diceRolled;
    }
}
