package application.fields;

import javafx.scene.paint.Color;

public class FinishField extends BoardField {
    public FinishField(int x, int y) {
        super(x, y);
        color = Color.RED;
        shapeX.setFill(color);
    }
}