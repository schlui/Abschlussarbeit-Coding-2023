package com.example.abschlussprojekt2023;

import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LoopEnd extends Objects {

    public LoopEnd(VBox process, VBox objects) {
        super(process, objects);
    }

    @Override
    public void initRectangle() {

        super.initRectangle();
        rectangle.setFill(Color.LIGHTBLUE);
        droppedrectangle.setFill(Color.LIGHTBLUE);
        process.getChildren().addAll(droppedrectangle);

        rectangle.setOnDragDetected(event -> {
            Dragboard db = rectangle.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString(rectangle.getStyle());
            db.setContent(content);
            event.consume();
        });
        process.setOnDragOver(event -> {
            if (event.getGestureSource() != process) {
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
                process.getChildren().add(droppedrectangle);
                success = true;
            }
            event.setDropCompleted(success);
            event.consume();

            rectangle.setOnDragDone(DragEvent::consume);

        });

    }

}
