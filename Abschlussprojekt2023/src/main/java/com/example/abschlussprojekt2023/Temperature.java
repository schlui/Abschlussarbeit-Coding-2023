package com.example.abschlussprojekt2023;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Temperature extends Set {

    public Temperature() {
        super();
    }
    
    @Override
    public void initRectangle() {
        super.initRectangle();
        rectangle.setFill(Color.DARKGREEN);
    }

}
