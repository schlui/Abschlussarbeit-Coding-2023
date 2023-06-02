package com.example.abschlussprojekt2023;

import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;


public class Objects {

    String name;

    protected Rectangle rectangle;

    

    private double mouseDragOffsetY;

    private VBox process;
    private VBox objects;

   

    


    public Objects() {
            process = new VBox();
            objects = new VBox();

    }
    public VBox getprocessBox() {
            return process;
    }

    public VBox getobjectBox() {
            return objects;
    }

    public void initRectangle() {
        rectangle = new Rectangle();
        rectangle.setX(50);
        rectangle.setY(50);
        rectangle.setWidth(200);
        rectangle.setHeight(50);
        rectangle.setFill(Color.BLUE);
    }
    public void makeDraggable(VBox objects) {
        this.getRectangle().setOnDragDetected(event -> {
            Dragboard db = this.getRectangle().startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.put(DataFormat.PLAIN_TEXT, "Drag Me");
            db.setContent(content);
            event.getX();
            this.mouseDragOffsetY = event.getY();
            event.consume();
        });
    
        this.getRectangle().setOnDragOver(event -> {
            if (event.getGestureSource() != this.getRectangle() && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });
    
        this.getRectangle().setOnDragEntered(event -> {
            if (event.getGestureSource() != this.getRectangle() && event.getDragboard().hasString()) {
                this.getRectangle().setOpacity(0.5);
            }
        });
    
        this.getRectangle().setOnDragExited(event -> {
            this.getRectangle().setOpacity(1);
        });
    
        this.getRectangle().setOnDragDropped(event -> extracted(event));
    
        this.getRectangle().setOnDragDone(event -> {
            if (event.getTransferMode() == TransferMode.MOVE) {
                
            }
            event.consume();
        });
    }

    private void extracted(DragEvent event) {
        if (event.getGestureSource() != this.getRectangle() && event.getDragboard().hasString()) {
            double x = event.getX();
            double y = event.getY();
      
            // Find the VBox under the mouse cursor
            Node node = event.getPickResult().getIntersectedNode();
            while (node != null && !(node instanceof VBox)) {
                node = node.getParent();
            }
            VBox process = (VBox) node;
      
            if (process != null) {
                
                process.getChildren().add(this.getRectangle());
                this.getRectangle().setLayoutX(x);
                this.getRectangle().setLayoutY(y);
            }
        }
        event.setDropCompleted(true);
        event.consume();
    }
    

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }






    
}




