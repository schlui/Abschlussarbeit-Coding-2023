package com.example.abschlussprojekt2023;

import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Objects {




    String name;

    public void clicked() {

    }

    public void dragAndDrop() {

    }



    protected Rectangle rectangle;

    public Objects() {
       
    }

    public void initRectangle() {
        rectangle = new Rectangle();
        rectangle.setX(50);
        rectangle.setY(50);
        rectangle.setWidth(200);
        rectangle.setHeight(50);
        rectangle.setFill(Color.BLUE);

        // Drag and Drop-Events hinzufügen
        rectangle.setOnMousePressed(event -> {
            rectangle.setCursor(Cursor.CLOSED_HAND);
        });

        rectangle.setOnMouseDragged(event -> {
            double offsetX = event.getSceneX() - rectangle.getTranslateX();
            double offsetY = event.getSceneY() - rectangle.getTranslateY();
            rectangle.setX(offsetX);
            rectangle.setY(offsetY);
        });

        rectangle.setOnMouseReleased(event -> {
            rectangle.setCursor(Cursor.DEFAULT);
        });
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }


    

}


