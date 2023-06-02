package com.example.abschlussprojekt2023;

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class Main extends Application {

   
    @Override
    public void start(Stage stage) throws IOException {
        VBox objects = new VBox();
        VBox process = new VBox();
        VBox status = new VBox();
        HBox group = new HBox();
        BorderPane root = new BorderPane();

        Scene scene = new Scene(root, 1200, 750, Color.LIGHTBLUE);

        // TOOLBAR
        ToolBar toolbar = new ToolBar();

        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("Datei");
        // Dropdown Buttons
        MenuItem oeffnen = new MenuItem("Öffnen");
        MenuItem speichern = new MenuItem("Speichern");
        MenuItem loeschen = new MenuItem("Löschen");

        oeffnen.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Datei öffnen");
            File selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) {
                System.out.println("Datei ausgewählt: " + selectedFile.getName());
            }
        });

        fileMenu.getItems().addAll(oeffnen, speichern, loeschen);
        menuBar.getMenus().add(fileMenu);

        toolbar.getItems().add(menuBar);

        // Buttons für Play, Pause und Reset
        Button playButton = new Button("Play");
        Button pauseButton = new Button("️Pause");
        Button resetButton = new Button("️Reset");


        ToolBar buttonToolbar = new ToolBar(playButton, pauseButton, resetButton);
        buttonToolbar.setPadding(new Insets(5));

        // Action Handler für die Buttons hinzufügen
        playButton.setOnAction(e -> {
            System.out.println("Play Button geklickt");
            // Hier den Code für das Abspielen einfügen
        });

        pauseButton.setOnAction(e -> {
            System.out.println("Pause Button geklickt");
            // Hier den Code für das Anhalten einfügen
        });

        resetButton.setOnAction(e -> {
            System.out.println("Reset Button geklickt");
            // Hier den Code für das Zurücksetzen einfügen
        });

        // Die Buttons der unteren ToolBar hinzufügen
        root.setBottom(buttonToolbar);

        root.setTop(toolbar);

        DoubleBinding spacePercent = scene.widthProperty().multiply(0.025);
        int space = spacePercent.intValue();
        CornerRadii radii = new CornerRadii(5);


        // Objects
        LoopStart obj_loopStart = new LoopStart();
        obj_loopStart.initRectangle();
        makeRectangleClickable(obj_loopStart.getRectangle(), process);
        obj_loopStart.makeDraggable(process);

        LoopEnd obj_loopEnd = new LoopEnd();
        obj_loopEnd.initRectangle();
        makeRectangleClickable(obj_loopEnd.getRectangle(), process);
        obj_loopEnd.makeDraggable(process);

        Temperature obj_temp = new Temperature();
        obj_temp.initRectangle();
        makeRectangleClickable(obj_temp.getRectangle(), process);
        obj_temp.makeDraggable(process);

        Humidity obj_hum = new Humidity();
        obj_hum.initRectangle();
        makeRectangleClickable(obj_hum.getRectangle(), process);
        obj_temp.makeDraggable(process);

        Delay obj_delay = new Delay();
        obj_delay.initRectangle();
        makeRectangleClickable(obj_delay.getRectangle(), process);
        obj_delay.makeDraggable(process);

        // Status

        Label Temp_now = new Label("Temp:");
        Label Hum_now = new Label("Hum:");
        Label Status_now = new Label("Status:");
        Label Position_now = new Label("Position:");


        //Areas 
        objects.setSpacing(10);
        objects.prefWidthProperty().bind(scene.widthProperty().multiply(0.20));
        objects.prefHeightProperty().bind(scene.heightProperty().multiply(0.95));
        objects.setBackground(new Background(new BackgroundFill(Color.GREY, radii, null)));
        objects.setPadding(new Insets(10));
        objects.getChildren().addAll(obj_loopStart.getRectangle(), obj_loopEnd.getRectangle(), obj_temp.getRectangle(), obj_hum.getRectangle(), obj_delay.getRectangle());

        process.setSpacing(10);
        process.prefWidthProperty().bind(scene.widthProperty().multiply(0.5));
        process.prefHeightProperty().bind(scene.heightProperty().multiply(0.95));
        process.setBackground(new Background(new BackgroundFill(Color.GREY, radii, null)));
        process.setPadding(new Insets(10));

        status.setSpacing(10);
        status.prefWidthProperty().bind(scene.widthProperty().multiply(0.20));
        status.prefHeightProperty().bind(scene.heightProperty().multiply(0.90) );
        status.setBackground(new Background(new BackgroundFill(Color.GREY, radii, null)));
        status.setPadding(new Insets(10));
        status.getChildren().addAll(Status_now, Temp_now, Hum_now, Position_now);

        group.setSpacing(space);
        group.setPadding(new Insets(space));
        group.getChildren().addAll(objects, process, status);
        group.setAlignment(Pos.CENTER);

        root.setCenter(group);
        scene.setFill(Color.LIGHTBLUE);
        stage.setScene(scene);


        stage.setTitle("Abschlussprojekt 2023");
        stage.show();
    }



    private void makeRectangleClickable(Rectangle rectangle, VBox process) {
        rectangle.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Zahlenwert eingeben");
                dialog.setHeaderText("Bitte geben Sie einen Zahlenwert ein:");
                dialog.setContentText("Zahlenwert:");

                Optional<String> result = dialog.showAndWait();
                result.ifPresent(value -> {
                    System.out.println("Eingegebener Zahlenwert: " + value); 
                });
            }
        });
    }


    public static void main(String[] args) {
        launch();
    }
}

