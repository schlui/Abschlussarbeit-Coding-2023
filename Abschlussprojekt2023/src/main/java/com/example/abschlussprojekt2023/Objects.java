package com.example.abschlussprojekt2023;

import javafx.geometry.Point2D;
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
        
        rectangle.setOnMousePressed(e -> {
            rectangle.setUserData(new Point2D(e.getSceneX() - rectangle.getX(), e.getSceneY() - rectangle.getY()));
        });

        rectangle.setOnMouseDragged(e -> {
            Point2D start = (Point2D) rectangle.getUserData();
    

            double newX = e.getSceneX() - start.getX();
            double newY = e.getSceneY() - start.getY();
    
            rectangle.setX(newX);
            rectangle.setY(newY);
        });

        rectangle.setOnMouseReleased(e -> {
           
            rectangle.setUserData(null);
        });

    }

    public  Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }


    

}


