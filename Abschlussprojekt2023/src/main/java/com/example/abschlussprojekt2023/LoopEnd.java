package com.example.abschlussprojekt2023;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class LoopEnd extends Loops {


    public LoopEnd(VBox process, VBox objects) {
        super(process, objects);
    }

    @Override
    public void initRectangle() {

        super.initRectangle();
        rectangle.setFill(Color.LIGHTBLUE);
        droppedrectangle.setFill(Color.LIGHTBLUE);
    }




}
