package application.fields;

import application.fields.BoardField;
import javafx.scene.paint.Color;

public class SpecialField extends BoardField {
    public SpecialField(int x, int y) {
        super(x, y);
        color = Color.PURPLE;
        shapeX.setFill(color);
    }
}