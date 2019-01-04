package application;

import application.fields.*;
import javafx.scene.layout.Pane;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Board extends Pane {

    public int boardX = 9;
    public int boardY = 9;

    private int playerPosition = 0;
    private int computerPosition = 0;
    private int maxPosition = 48;

    public List<BoardField> fields = new LinkedList<>();
    public List<BoardField> blankFields = new LinkedList<>();

    public List<BoardField> getBlankFields() {
        return blankFields;
    }
    public List<BoardField> getFields() {
        return fields;
    }

    public int getMaxPosition() {
        return maxPosition;
    }
    public int getPlayerPosition() {
        return playerPosition;
    }
    public int getComputerPosition() {
        return computerPosition;
    }

    public void setComputerPosition(int computerPosition) {
        this.computerPosition = computerPosition;
    }
    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    public void generateBlankFields() {
        BoardField bf1 = new BlankField(1, 0);
        BoardField bf2 = new BlankField(1, 1);
        BoardField bf3 = new BlankField(1, 2);
        BoardField bf4 = new BlankField(1, 3);
        BoardField bf5 = new BlankField(1, 4);
        BoardField bf6 = new BlankField(1, 5);
        BoardField bf7 = new BlankField(1, 6);
        BoardField bf8 = new BlankField(1, 7);

        BoardField bf10 = new BlankField(3, 1);
        BoardField bf11 = new BlankField(3, 2);
        BoardField bf12 = new BlankField(3, 3);
        BoardField bf13 = new BlankField(3, 1);
        BoardField bf14 = new BlankField(3, 4);
        BoardField bf15 = new BlankField(3, 5);
        BoardField bf16 = new BlankField(3, 6);
        BoardField bf17 = new BlankField(3, 7);
        BoardField bf18 = new BlankField(3, 8);

        BoardField bf19 = new BlankField(5, 0);
        BoardField bf20 = new BlankField(5, 1);
        BoardField bf21 = new BlankField(5, 2);
        BoardField bf22 = new BlankField(5, 3);
        BoardField bf23 = new BlankField(5, 4);
        BoardField bf24 = new BlankField(5, 5);
        BoardField bf25 = new BlankField(5, 6);
        BoardField bf26 = new BlankField(5, 7);

        BoardField bf27 = new BlankField(7, 1);
        BoardField bf28 = new BlankField(7, 2);
        BoardField bf29 = new BlankField(7, 3);
        BoardField bf30 = new BlankField(7, 4);
        BoardField bf31 = new BlankField(7, 5);
        BoardField bf32 = new BlankField(7, 6);
        BoardField bf33 = new BlankField(7, 7);
        BoardField bf34 = new BlankField(7, 8);

        blankFields.add(bf1);
        blankFields.add(bf2);
        blankFields.add(bf3);
        blankFields.add(bf4);
        blankFields.add(bf5);
        blankFields.add(bf6);
        blankFields.add(bf7);
        blankFields.add(bf8);
        blankFields.add(bf10);
        blankFields.add(bf11);
        blankFields.add(bf12);
        blankFields.add(bf13);
        blankFields.add(bf14);
        blankFields.add(bf15);
        blankFields.add(bf16);
        blankFields.add(bf17);
        blankFields.add(bf18);
        blankFields.add(bf19);
        blankFields.add(bf20);
        blankFields.add(bf21);
        blankFields.add(bf22);
        blankFields.add(bf23);
        blankFields.add(bf24);
        blankFields.add(bf25);
        blankFields.add(bf26);
        blankFields.add(bf27);
        blankFields.add(bf28);
        blankFields.add(bf29);
        blankFields.add(bf30);
        blankFields.add(bf31);
        blankFields.add(bf32);
        blankFields.add(bf33);
        blankFields.add(bf34);
    }
    public void generateStartField() {
        BoardField startField = new StartField(0, 0);
        fields.add(startField);
    }
    public void generatePlayableFields() {
        BoardField pf1 = new PlayableField(0, 1);
        BoardField pf2 = new PlayableField(0, 2);
        BoardField pf3 = new PlayableField(0, 3);
        BoardField pf4 = new PlayableField(0, 4);
        BoardField pf5 = new PlayableField(0, 5);
        BoardField pf6 = new PlayableField(0, 6);
        BoardField pf7 = new PlayableField(0, 7);
        BoardField pf8 = new PlayableField(0, 8);
        BoardField pf9 = new PlayableField(1, 8);

        BoardField pf10 = new PlayableField(2, 8);

        BoardField pf11 = new PlayableField(2, 7);
        BoardField pf12 = new PlayableField(2, 6);
        BoardField pf13 = new PlayableField(2, 5);
        BoardField pf14 = new PlayableField(2, 4);
        BoardField pf15 = new PlayableField(2, 3);
        BoardField pf16 = new PlayableField(2, 2);
        BoardField pf17 = new PlayableField(2, 1);
        BoardField pf18 = new PlayableField(2, 0);

        BoardField pf19 = new PlayableField(3, 0);

        BoardField pf20 = new PlayableField(4, 0);
        BoardField pf21 = new PlayableField(4, 1);
        BoardField pf22 = new PlayableField(4, 2);
        BoardField pf23 = new PlayableField(4, 3);
        BoardField pf24 = new PlayableField(4, 4);
        BoardField pf25 = new PlayableField(4, 5);
        BoardField pf26 = new PlayableField(4, 6);
        BoardField pf27 = new PlayableField(4, 7);
        BoardField pf28 = new PlayableField(4, 8);

        BoardField pf29 = new PlayableField(5, 8);
        BoardField pf30 = new PlayableField(6, 8);
        BoardField pf31 = new PlayableField(6, 7);
        BoardField pf32 = new PlayableField(6, 6);
        BoardField pf33 = new PlayableField(6, 5);
        BoardField pf34 = new PlayableField(6, 4);
        BoardField pf35 = new PlayableField(6, 3);
        BoardField pf36 = new PlayableField(6, 2);
        BoardField pf37 = new PlayableField(6, 1);
        BoardField pf38 = new PlayableField(6, 0);

        BoardField pf39 = new PlayableField(7, 0);

        BoardField pf40 = new PlayableField(8, 0);
        BoardField pf41 = new PlayableField(8, 1);
        BoardField pf42 = new PlayableField(8, 2);
        BoardField pf43 = new PlayableField(8, 3);
        BoardField pf44 = new PlayableField(8, 4);
        BoardField pf45 = new PlayableField(8, 5);
        BoardField pf46 = new PlayableField(8, 6);
        BoardField pf47 = new PlayableField(8, 7);

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
    }
    public void generateSpecialFields() {
        BoardField sp1 = new SpecialField(0,4);
        BoardField sp2 = new SpecialField(2,3);
        BoardField sp3 = new SpecialField(2,7);
        BoardField sp4 = new SpecialField(4,0);
        BoardField sp5 = new SpecialField(4,4);
        BoardField sp6 = new SpecialField(6,2);
        BoardField sp7 = new SpecialField(6,6);
        BoardField sp8 = new SpecialField(8,2);
        BoardField sp9 = new SpecialField(8,5);

        fields.set(4, sp1);
        fields.set(15, sp2);
        fields.set(11, sp3);
        fields.set(20, sp4);
        fields.set(24, sp5);
        fields.set(36, sp6);
        fields.set(32, sp7);
        fields.set(42, sp8);
        fields.set(45, sp9);

    }
    public void generateFinishField() {
        BoardField finishField = new FinishField(8, 8);
        fields.add(finishField);
    }

    public void generateBoard(){
        generateBlankFields();
        generateStartField();
        generatePlayableFields();
        generateSpecialFields();
        generateFinishField();
    }
    public void ng(){
        setComputerPosition(0);
        setPlayerPosition(0);
    }
}

