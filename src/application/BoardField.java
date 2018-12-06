package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.awt.*;

public class BoardField extends Pane {

    private int x;
    private int y;
    private Paint color;
    private boolean isUserOn = false;
    private Shape shapeX;
    private Shape shapeY;



    public Shape getShapeX() {
        return shapeX;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "BoardField{" +
                "x=" + x +
                ", y=" + y +
                ", color=" + color +
                '}';
    }

    public BoardField(int x, int y, Paint color) {
        this.x = x;
        this.y = y;
        this.color = color;
        shapeX = new Rectangle(50, 50);
        shapeX.setFill(color);
        shapeX.setStroke(Color.BLACK);
        shapeX.setStrokeType(StrokeType.OUTSIDE);
        shapeX.setStrokeWidth(1);
    }
    public boolean isUserOn() {
        return isUserOn;
    }

    public void setUserOn(boolean userOn) {
        isUserOn = userOn;
        if (isUserOn) {
            shapeX = new Rectangle(10, 10);
        }else{
            shapeX = new Rectangle(50, 50);
        }
    }


}
