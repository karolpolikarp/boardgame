package application.fields;

import application.Board;
import javafx.scene.paint.Color;

public class SpecialField extends BoardField {
    Board board;
    BoardField boardField;
    public SpecialField(int x, int y) {
        super(x, y);
        color = Color.PURPLE;
        shapeX.setFill(color);
        if (isUserOn()) {
            board.setPlayerPosition(board.getPlayerPosition() + 3);
        }
    }
}