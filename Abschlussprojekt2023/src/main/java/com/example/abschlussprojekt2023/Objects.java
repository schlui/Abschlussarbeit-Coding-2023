package com.example.abschlussprojekt2023;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class Objects extends Node {

    protected Rectangle rectangle;
    protected Rectangle droppedRectangle = new Rectangle();

    protected VBox process;
    protected VBox objects;

    public Objects(VBox process, VBox objects) {
        this.process = process;
        this.objects = objects;
    }

    public void initRectangle() {
        rectangle = new Rectangle();
        rectangle.setX(50);
        rectangle.setY(50);
        rectangle.setWidth(200);
        rectangle.setHeight(50);

        objects.getChildren().add(rectangle);

        rectangle.setOnDragDetected(event -> {
            Dragboard dragboard = rectangle.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent clipboardContent = new ClipboardContent();
            clipboardContent.putString(rectangle.getId());
            dragboard.setContent(clipboardContent);
            event.consume();
        });

        process.setOnDragOver(event -> {
            if (event.getGestureSource() != process && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        process.setOnDragDropped(event -> {
            Dragboard dragboard = event.getDragboard();
            boolean success = false;
            if (dragboard.hasString()) {
                droppedRectangle.setId(dragboard.getString());
                droppedRectangle.setWidth(rectangle.getWidth());
                droppedRectangle.setHeight(rectangle.getHeight());

                double x = event.getX() - (droppedRectangle.getWidth() / 2);
                double y = event.getY() - (droppedRectangle.getHeight() / 2);
                droppedRectangle.setX(x);
                droppedRectangle.setY(y);

                process.getChildren().add(droppedRectangle);
                success = true;
            }
            event.setDropCompleted(success);
            event.consume();
        });

        droppedRectangle.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                process.getChildren().remove(droppedRectangle);
            }
        });

        droppedRectangle.setOnDragDetected(event -> {
            Dragboard dragboard = droppedRectangle.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent clipboardContent = new ClipboardContent();
            clipboardContent.putString(droppedRectangle.getId());
            dragboard.setContent(clipboardContent);
            event.consume();
        });

        droppedRectangle.setOnDragOver(event -> {
            if (event.getGestureSource() != droppedRectangle && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        droppedRectangle.setOnDragDropped(event -> {
            Dragboard dragboard = event.getDragboard();
            boolean success = false;
            if (dragboard.hasString()) {
                droppedRectangle.setId(dragboard.getString());

                double x = event.getX() - (droppedRectangle.getWidth() / 2);
                double y = event.getY() - (droppedRectangle.getHeight() / 2);
                droppedRectangle.setX(x);
                droppedRectangle.setY(y);

                success = true;
            }
            event.setDropCompleted(success);
            event.consume();
        });

        droppedRectangle.setOnDragDone(DragEvent::consume);
    }

    private void openInputDialog() {
        Dialog<Double> dialog = new Dialog<>();
        dialog.setTitle("Zahlenwert eingeben");
        dialog.setHeaderText("Geben Sie einen Zahlenwert ein:");

        TextField inputField = new TextField();
        dialog.getDialogPane().setContent(inputField);
        String x = inputField.getText();
        int new_int = Integer.parseInt(x);

        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        dialog.setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {
                String inputText = inputField.getText();
                try {
                    double value = Double.parseDouble(inputText);
                    return value;
                } catch (NumberFormatException e) {
                    showAlert("Fehler", "Ungültige Eingabe", "Bitte geben Sie eine gültige Zahl ein.");
                }
            }
            return null;
        });

        dialog.showAndWait().ifPresent(result -> {
            droppedRectangle.getProperties().put("Value", result);
            showAlert("Erfolgreich", "Zahlenwert gespeichert", "Der Zahlenwert wurde erfolgreich gespeichert.");
        });
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
