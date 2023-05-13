package com.example.abschlussprojekt2023;

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.DataFormat;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {
    private static final DataFormat OBJECT_FORMAT = new DataFormat("application/x-java-serialized-object");

    private VBox objects;
    private VBox process;
    private LoopStart obj_loopStart;
    private LoopEnd obj_loopEnd;

    private Humidity obj_hum;
    private Temperature obj_temp;
    private Delay obj_delay;

    @Override
    public void start(Stage stage) throws IOException {

        objects = new VBox();
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

        root.setTop(toolbar);

        DoubleBinding spacePercent = scene.widthProperty().multiply(0.025);
        int space = spacePercent.intValue();
        CornerRadii radii = new CornerRadii(5);

        obj_loopStart = new LoopStart();
        obj_loopStart.initRectangle();
        obj_loopStart.makeDraggable(process);

        obj_loopEnd = new LoopEnd();
        obj_loopEnd.initRectangle();
        obj_loopEnd.makeDraggable(process);

        obj_temp = new Temperature();
        obj_temp.initRectangle();
        obj_temp.makeDraggable(process);

        obj_hum = new Humidity();
        obj_hum.initRectangle();
        obj_hum.makeDraggable(process);

        Objects obj_delay = new Delay();
        obj_delay.initRectangle();
        obj_delay.makeDraggable(process);

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
        status.prefHeightProperty().bind(scene.heightProperty().multiply(0.9));
        status.setBackground(new Background(new BackgroundFill(Color.GREY, radii, null)));
        status.setPadding(new Insets(10));

        group.setSpacing(space);
        group.setPadding(new Insets(space));
        group.getChildren().addAll( objects, process, status);
        group.setAlignment(Pos.CENTER);

        root.setCenter(group);

        stage.setScene(scene);
        stage.setTitle("Abschlussprojekt 2023");
        stage.show();

    }
        
        
        
        

        
    

  
    public static void main(String[] args) {
        launch();
    }
}
