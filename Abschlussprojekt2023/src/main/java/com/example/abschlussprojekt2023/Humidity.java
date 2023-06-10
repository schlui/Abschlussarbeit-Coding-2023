package com.example.abschlussprojekt2023;

import javafx.scene.input.*;
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

        rectangle.setOnDragDetected(event -> {
            Dragboard db = rectangle.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString(rectangle.getStyle());
            db.setContent(content);
            event.consume();
        });

        process.setOnDragOver(event -> {
            if (event.getGestureSource() != process ) {
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            event.consume();
        });

        process.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db != null) {
                droppedrectangle = new Rectangle();
                droppedrectangle.setWidth(rectangle.getWidth());
                droppedrectangle.setHeight(rectangle.getHeight());
                droppedrectangle.setFill(rectangle.getFill());
                process.getChildren().addAll(droppedrectangle);
                success = true;
            }
            event.setDropCompleted(success);
            event.consume();



            rectangle.setOnDragDone(DragEvent::consume);


        });
        

    }
}
