package com.example.abschlussprojekt2023;

import javafx.scene.input.Dragboard;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Humidity extends Set{


    public Humidity(VBox process, VBox objects) {
        super(process, objects);
    }



    @Override
    public void initRectangle() {

        super.initRectangle();
        rectangle.setFill(Color.BLUEVIOLET);
        droppedrectangle.setFill(Color.BLUEVIOLET);
       

        

    }
}
