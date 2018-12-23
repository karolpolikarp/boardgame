package application.fields;

import application.fields.BoardField;
import javafx.scene.paint.Color;

public class StartField extends BoardField {
    public StartField(int x, int y) {
        super(x, y);
        color = Color.GREEN;
        shapeX.setFill(color);
    }
}