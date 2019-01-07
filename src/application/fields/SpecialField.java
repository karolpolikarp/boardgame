package application.fields;

import application.Board;
import javafx.scene.paint.Color;

public class SpecialField extends BoardField {
    public SpecialField(int x, int y) {
        super(x, y);
        color = Color.HOTPINK;
        shapeX.setFill(color);
    }
}