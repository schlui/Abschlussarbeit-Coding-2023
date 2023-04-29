package com.example.abschlussprojekt2023;

import javafx.scene.shape.Rectangle;

public class Objects {

    String name;
  

  private Rectangle rectangle;

    public Objects() {
        rectangle = new Rectangle();
        rectangle.setX(50);
        rectangle.setY(50);
        rectangle.setWidth(100);
        rectangle.setHeight(100);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }


    public void clicked() {

    }

    public void dragAndDrop() {

    }

}


    

