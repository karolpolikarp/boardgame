package application.fields;

import javafx.scene.paint.Color;

public class BackgroundField extends BoardField {
    public BackgroundField(int x, int y) {
        super(x, y);
        color = Color.WHEAT;
        shapeX.setFill(color);
    }
}
