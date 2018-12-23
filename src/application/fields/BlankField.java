package application.fields;

import javafx.scene.paint.Color;

public class BlankField extends BoardField {
    public BlankField(int x, int y) {
        super(x, y);
        color = Color.DEEPSKYBLUE;
        shapeX.setFill(color);
    }
}
