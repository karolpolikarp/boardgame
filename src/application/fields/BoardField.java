package application.fields;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;


public class BoardField extends Pane {

    public int x;
    public int y;

    public Paint getColor() {
        return color;
    }

    public void setColor(Paint color) {
        this.color = color;
    }

    public Paint color;
//    private Paint originalColor;
    private boolean isUserOn = false;
    private boolean isComputerOn = false;
    public Shape shapeX;
    public Shape shapeY;

    public Shape getShapeY() {
        return shapeY;
    }

    public BoardField(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.shapeX = shapeX;
        this.shapeY = shapeY;
        shapeX = new Rectangle(50, 50, Color.TRANSPARENT);
        shapeY = new Rectangle(50,50, Color.TRANSPARENT);
        shapeX.setFill(color);
        shapeX.setStroke(Color.BLACK);
        shapeX.setStrokeType(StrokeType.OUTSIDE);
        shapeX.setStrokeWidth(1);
        ///shapeY = new Text(); ///tile number lub 2x tiles na jednym
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

    @Override
    public String toString() {
        return "BoardField{" +
                "x=" + x +
                ", y=" + y +
                ", color=" + color +
                '}';
    }

    public boolean isUserOn() {
        return isUserOn;
    }

    public boolean isComputerOn() {
        return isComputerOn;
    }

    public void setUserOn(boolean userOn) {
        isUserOn = userOn;
        if (isUserOn) {
            shapeY = new Circle(25, Color.BLACK);
        }else{
            shapeY = null;
        }
        if (isComputerOn) {
            shapeY = new Rectangle(25, 25, Color.RED);
        }
    }
    public void setComputerOn(boolean computerOn) {
        isComputerOn = computerOn;
        if (isComputerOn) {
            shapeY = new Circle(25, Color.YELLOWGREEN);
        }else{
            shapeY = null;
        }
        if (isUserOn) {
            shapeY = new Rectangle(25, 25, Color.RED);
        }
    }

}
