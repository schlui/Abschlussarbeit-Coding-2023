package com.example.abschlussprojekt2023;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Delay extends Objects{


    public Delay(VBox process, VBox objects) {
        super(process, objects);
    }



    @Override
    public void initRectangle() {

        super.initRectangle();
        rectangle.setFill(Color.PINK);
        droppedrectangle.setFill(Color.PINK);


    }
}

