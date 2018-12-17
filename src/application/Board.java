package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;

public class Board extends Pane {

    public int boardX = 9;
    public int boardY = 9;
    public int y;
    public int x;
    public int b;


    private List<BoardField> fields = new LinkedList<>();
    private List<BoardField> playableFields = new LinkedList<>();

    Dice dice = new Dice(6);
    private int diceRolled;

    public List getPlayableFields() {
        return playableFields;
    }
    public void setPlayableFields(List playableFields) {
        this.playableFields = playableFields;
    }
    public int getDiceRolled() {
        return diceRolled;
    }
    public List<BoardField> getFields() {
        return fields;
    }
    public void diceSetter(){
        diceRolled = dice.roll();
        fields.get(diceRolled).setUserOn(true);
    }

    public Board() {

        BoardField startField = new BoardField(0,0, Color.GREEN, 0, 1, -1, -1 );

        BoardField pf1 = new BoardField(0,1, Color.WHEAT, 0, 2, 0, 0 );
        BoardField pf2 = new BoardField(0,2, Color.WHEAT, 0, 3, 0, 1 );
        BoardField pf3 = new BoardField(0,3, Color.WHEAT, 0, 4, 0, 2 );
        BoardField pf4 = new BoardField(0,4, Color.WHEAT, 0, 5, 0, 3 );
        BoardField pf5 = new BoardField(0,5, Color.WHEAT, 0, 6, 0, 4 );
        BoardField pf6 = new BoardField(0,6, Color.WHEAT, 0, 7, 0, 5 );
        BoardField pf7 = new BoardField(0,7, Color.WHEAT, 0, 8, 0, 6 );
        BoardField pf8 = new BoardField(0,8, Color.WHEAT, 1, 8, 0, 7 );
        BoardField pf9 = new BoardField(1,8, Color.WHEAT, 2, 0, 0, 8 );

        BoardField pf10 = new BoardField(2,0, Color.WHEAT, 2, 1, 1, 8 );
        BoardField pf11 = new BoardField(2,1, Color.WHEAT, 2, 2, 2, 0 );
        BoardField pf12 = new BoardField(2,2, Color.WHEAT, 2, 3, 2, 1 );
        BoardField pf13 = new BoardField(2,3, Color.WHEAT, 2, 4, 2, 2 );
        BoardField pf14 = new BoardField(2,4, Color.WHEAT, 2, 5, 2, 3 );
        BoardField pf15 = new BoardField(2,5, Color.WHEAT, 2, 6, 2, 4 );
        BoardField pf16 = new BoardField(2,6, Color.WHEAT, 2, 7, 2, 5 );
        BoardField pf17 = new BoardField(2,7, Color.WHEAT, 2, 8, 2, 6 );
        BoardField pf18 = new BoardField(2,8, Color.WHEAT, 3, 0, 2, 7 );

        BoardField pf19 = new BoardField(3,0, Color.WHEAT, 4, 0, 2, 8 );

        BoardField pf20 = new BoardField(4,0, Color.WHEAT, 4, 1, 3, 0 );
        BoardField pf21 = new BoardField(4,1, Color.WHEAT, 4, 2, 4, 0 );
        BoardField pf22 = new BoardField(4,2, Color.WHEAT, 4, 3, 4, 1 );
        BoardField pf23 = new BoardField(4,3, Color.WHEAT, 4, 4, 4, 2 );
        BoardField pf24 = new BoardField(4,4, Color.WHEAT, 4, 5, 4, 3 );
        BoardField pf25 = new BoardField(4,5, Color.WHEAT, 4, 6, 4, 4 );
        BoardField pf26 = new BoardField(4,6, Color.WHEAT, 4, 7, 4, 5 );
        BoardField pf27 = new BoardField(4,7, Color.WHEAT, 4, 8, 4, 6 );
        BoardField pf28 = new BoardField(4,8, Color.WHEAT, 5, 8, 4, 7 );

        BoardField pf29 = new BoardField(5,8, Color.WHEAT, 6, 0, 4, 8 );

        BoardField pf30 = new BoardField(6,0, Color.WHEAT, 6, 1, 5, 8 );
        BoardField pf31 = new BoardField(6,1, Color.WHEAT, 6, 2, 6, 0 );
        BoardField pf32 = new BoardField(6,2, Color.WHEAT, 6, 3, 6, 1 );
        BoardField pf33 = new BoardField(6,3, Color.WHEAT, 6, 4, 6, 2 );
        BoardField pf34 = new BoardField(6,4, Color.WHEAT, 6, 5, 6, 3 );
        BoardField pf35 = new BoardField(6,5, Color.WHEAT, 6, 6, 6, 4 );
        BoardField pf36 = new BoardField(6,6, Color.WHEAT, 6, 7, 6, 5 );
        BoardField pf37 = new BoardField(6,7, Color.WHEAT, 6, 8, 6, 6 );
        BoardField pf38 = new BoardField(6,8, Color.WHEAT, 7, 0, 6, 7 );

        BoardField pf39 = new BoardField(7,0, Color.WHEAT, 8, 0, 6, 8 );

        BoardField pf40 = new BoardField(8,0, Color.WHEAT, 8, 1, 7, 0 );
        BoardField pf41 = new BoardField(8,1, Color.WHEAT, 8, 2, 8, 0 );
        BoardField pf42 = new BoardField(8,2, Color.WHEAT, 8, 3, 8, 1 );
        BoardField pf43 = new BoardField(8,3, Color.WHEAT, 8, 4, 8, 2 );
        BoardField pf44 = new BoardField(8,4, Color.WHEAT, 8, 5, 8, 3 );
        BoardField pf45 = new BoardField(8,5, Color.WHEAT, 8, 6, 8, 4 );
        BoardField pf46 = new BoardField(8,6, Color.WHEAT, 8, 7, 8, 5 );
        BoardField pf47 = new BoardField(8,7, Color.WHEAT, 8, 8, 8, 6 );

        BoardField lastField = new BoardField(8,8, Color.RED, -1, -1, 8, 7 );


        fields.add(startField);

//        for (int b = 1; b < 48, b++)
//            fields.add(pf(b))

        fields.add(pf1);
        fields.add(pf2);
        fields.add(pf3);
        fields.add(pf4);
        fields.add(pf5);
        fields.add(pf6);
        fields.add(pf7);
        fields.add(pf8);
        fields.add(pf9);
        fields.add(pf10);
        fields.add(pf11);
        fields.add(pf12);
        fields.add(pf13);
        fields.add(pf14);
        fields.add(pf15);
        fields.add(pf16);
        fields.add(pf17);
        fields.add(pf18);
        fields.add(pf19);
        fields.add(pf20);
        fields.add(pf21);
        fields.add(pf22);
        fields.add(pf23);
        fields.add(pf24);
        fields.add(pf25);
        fields.add(pf26);
        fields.add(pf27);
        fields.add(pf28);
        fields.add(pf29);
        fields.add(pf30);
        fields.add(pf31);
        fields.add(pf32);
        fields.add(pf33);
        fields.add(pf34);
        fields.add(pf35);
        fields.add(pf36);
        fields.add(pf37);
        fields.add(pf38);
        fields.add(pf39);
        fields.add(pf40);
        fields.add(pf41);
        fields.add(pf42);
        fields.add(pf43);
        fields.add(pf44);
        fields.add(pf45);
        fields.add(pf46);
        fields.add(pf47);


        fields.add(lastField);














//        for (int x = 0; x < boardX; x++) { //przemodelowanie petli (zrezygnowanie z petli, recznie)
//            for (int y = 0; y < boardY; y++) {
//                if (((x == 0 && y == 0))) {
//                    BoardField bf = new BoardField(x, y, Color.GREEN, 0, 1, -1, -1);
//                    fields.add(bf);
//                    playableFields.add(bf);
//                } else if((((x == 8 && y == 8)))){
//                    BoardField bf = new BoardField(x, y, Color.RED, -1, -1, -1, -1);
//                    fields.add(bf);
//                    playableFields.add(bf);
//                } else if ((((x % 2 == 0) || ((x == 1 && y == 8) || (x == 3 && y == 0))) || ((x == 5 && y == 8) || (x == 7 && y == 0)))) {
//                    BoardField bf = new BoardField(x, y, Color.WHEAT, -1, -1, -1, -1);
//                    fields.add(bf);
//                    playableFields.add(bf);
//                } else {
//                    BoardField bf = new BoardField(x, y, Color.DEEPSKYBLUE, -1, -1, -1, -1);
//                    fields.add(bf);
//                }
//            }
    }
//            playableFields.get(5).setSpecialTile(true);  //jak to zmienić na playablefields oraz ułożyc kolejność pól względem planszy
//            playableFields.get(22).setSpecialTile(true);
//            playableFields.get(40).setSpecialTile(true);
//            playableFields.get(60).setSpecialTile(true);
//            playableFields.get(75).setSpecialTile(true);

    //diceSetter();




//        for ( int o = 0; o < playableFields.size(); o++) {
//            System.out.println(o + 1 + " " + playableFields.get(o));
}
//
//
//}
//