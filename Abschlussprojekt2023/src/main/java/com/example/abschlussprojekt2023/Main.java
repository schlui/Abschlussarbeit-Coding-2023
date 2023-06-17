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
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    private Python_Interpreter python_interpreter;

    @Override
    public void start(Stage stage) throws IOException {
        VBox process = new VBox();
        VBox objects = new VBox();
        Objects obj = new Objects(process, objects);
        python_interpreter = new Python_Interpreter();

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


        HBox buttonbox = new HBox(playButton, pauseButton, resetButton);
        buttonbox.setPadding(new Insets(5));


        // Action Handler für die Buttons hinzufügen
        playButton.setOnAction(e -> {
            System.out.println("Play Button geklickt");
            // Code für Play:
        });

        pauseButton.setOnAction(e -> {
            System.out.println("Pause Button geklickt");
            // Code für Pause:
        });

        resetButton.setOnAction(e -> {
            System.out.println("Reset Button geklickt");
            // Code für reset:
        });

        root.setTop(toolbar);

        DoubleBinding spacePercent = scene.widthProperty().multiply(0.025);
        int space = spacePercent.intValue();
        CornerRadii radii = new CornerRadii(5);


        // Objects
        LoopStart obj_loopStart = new LoopStart(process, objects);
        obj_loopStart.initRectangle();

        LoopEnd obj_loopEnd = new LoopEnd(process, objects);
        obj_loopEnd.initRectangle();

        Temperature obj_temp = new Temperature(process, objects);
        obj_temp.initRectangle();

        Humidity obj_hum = new Humidity(process, objects);
        obj_hum.initRectangle();

        Delay obj_delay = new Delay(process, objects);
        obj_delay.initRectangle();

        Spray obj_spray = new Spray(process, objects);
        obj_spray.initRectangle();

        process.setPadding(new Insets(space));
        process.setSpacing(space);

        objects.setPadding(new Insets(space));
        objects.setSpacing(space);

        process.setBackground(new Background(new BackgroundFill(Color.WHITE, radii, Insets.EMPTY)));
        objects.setBackground(new Background(new BackgroundFill(Color.WHITE, radii, Insets.EMPTY)));

        group.setAlignment(Pos.TOP_CENTER);
        group.getChildren().addAll(process, objects);

        status.getChildren().add(group);

        root.setCenter(status);
        root.setBottom(buttonbox);

        stage.setScene(scene);
        stage.setTitle("Abschlussprojekt 2023");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
