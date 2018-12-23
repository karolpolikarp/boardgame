package application.fields;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

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
//    private boolean isSpecialTile = false;
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
        shapeY = new Circle(25);
    }
//    private int nextX;
//    private int nextY;
//    private int prevX;
//    private int prevY;

//    public int getNextX() {
//        return nextX;
//    }
//
//    public int getNextY() {
//        return nextY;
//    }
//
//    public int getPrevX() {
//        return prevX;
//    }
//
//    public int getPrevY() {
//        return prevY;
//    }

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

//    public BoardField(int x, int y, Paint color, int nextX, int nextY, int prevX, int prevY) {
//        this.x = x;
//        this.y = y;
//        this.color = color;
////        this.originalColor = color;
////        this.nextX = nextX;
////        this.nextY = nextY;
////        this.prevX = prevX;
////        this.prevY = prevY;
//        shapeX = new Rectangle(50, 50);
//        shapeX.setFill(color);
//        shapeX.setStroke(Color.BLACK);
//        shapeX.setStrokeType(StrokeType.OUTSIDE);
//        shapeX.setStrokeWidth(1);
//    }
//    public boolean isUserOn() {
//        return isUserOn;
//    }
//    public boolean isSpecialTile() {
//        return isSpecialTile();
//    }
//
//    public void setSpecialTile(boolean specialTile) {
//        isSpecialTile = specialTile;
//        if (isSpecialTile) {
//            shapeX = new Rectangle(50, 50, Color.PURPLE);
//            shapeX.setStroke(Color.BLACK);
//            shapeX.setStrokeType(StrokeType.OUTSIDE);
//            shapeX.setStrokeWidth(1);
//            // get player and cause effect
//        }else{
//            shapeX = new Rectangle(50,50);
//        }
//    }
//
    public void setUserOn(boolean userOn) {
        isUserOn = userOn;
        if (isUserOn) {
            shapeX = new Circle(25, Color.BLACK);
        }else{
            shapeX = new Rectangle(50, 50);
        }
    }


}
