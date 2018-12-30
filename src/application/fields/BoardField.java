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
        shapeX = new Rectangle(50, 50);
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
    public void setUserOn(boolean userOn) {
        isUserOn = userOn;
        if (isUserOn) {
            shapeX = new Circle(25, Color.BLACK);
            ///shapeY = new Text("yooy");
        }else{
            shapeX = new Rectangle(50, 50);
        }
    }


}
