package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class BoardField extends Pane {

    private int x;
    private int y;
    private Paint color;
    private boolean isUserOn = false;
    private Shape shapeX;

    public boolean isUserOn() {
        return isUserOn;
    }

    public void setUserOn(boolean userOn) {
        isUserOn = userOn;
        if (isUserOn) {
            shapeX = new Circle(25);
        }else{
            shapeX = new Rectangle(50, 50);
        }
    }


    public Shape getShapeX() {
        return shapeX;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public BoardField(int x, int y, Paint color) {
        this.x = x;
        this.y = y;
        shapeX = new Rectangle(50, 50);
        shapeX.setFill(color);
    }

}
