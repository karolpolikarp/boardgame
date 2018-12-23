package application.fields;

import javafx.scene.paint.Color;

public class PlayableField extends BoardField {
    public PlayableField(int x, int y) {
        super(x, y);
        color = Color.WHEAT;
        shapeX.setFill(color);
    }
}
