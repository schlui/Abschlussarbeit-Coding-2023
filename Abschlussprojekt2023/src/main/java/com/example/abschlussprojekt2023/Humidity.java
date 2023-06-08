package com.example.abschlussprojekt2023;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Humidity extends Set{


    public Humidity(VBox process, VBox objects) {
        super(process, objects);
    }

    @Override
    public void initRectangle() {

        super.initRectangle();
        rectangle.setFill(Color.LIGHTGREEN);
        droppedrectangle.setFill(Color.LIGHTBLUE);
    }
}
