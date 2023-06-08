package com.example.abschlussprojekt2023;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;




public class Objects extends Node {

    protected Rectangle rectangle;
    protected Rectangle droppedrectangle;

    protected  VBox process;
    protected  VBox objects;



    public Objects(VBox process, VBox objects) {
        this.process = process;
        this.objects =  objects;
    }

    /**
     * 
     */
    public void initRectangle() {

        rectangle = new Rectangle();
        rectangle.setX(50);
        rectangle.setY(50);
        rectangle.setWidth(200);
        rectangle.setHeight(50);
        

        objects.getChildren().add(rectangle);

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
                process.getChildren().add(droppedrectangle);
                success = true;
            }
            event.setDropCompleted(success);
            event.consume();

        });

        rectangle.setOnDragDone(DragEvent::consume);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }






}

