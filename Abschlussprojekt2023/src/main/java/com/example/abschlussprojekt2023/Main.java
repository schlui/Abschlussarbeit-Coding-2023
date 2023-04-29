package com.example.abschlussprojekt2023;

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {


      

        VBox objects = new VBox();
        VBox process = new VBox();
        VBox status = new VBox();
        HBox group = new HBox();
        Pane root = new Pane();

        Scene scene =  new Scene(root, 1200, 750, Color.LIGHTBLUE);




        //TOOLBAR


        DoubleBinding spacePercent = scene.widthProperty().multiply(0.025);
        int space = spacePercent.intValue();
        CornerRadii radii = new CornerRadii(5);

        
        LoopStart obj_loopStart = new LoopStart();
        obj_loopStart.initRectangle();

        LoopEnd obj_loopEnd = new LoopEnd();
        obj_loopEnd.initRectangle();
        
        Temperature obj_temp = new Temperature();
        obj_temp.initRectangle();

        Humidity obj_hum = new Humidity();
        obj_hum.initRectangle();

        Delay obj_delay = new Delay(); 
        obj_delay.initRectangle();


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

        root.getChildren().addAll(group);




        stage.setScene(scene);
        stage.setTitle("Abschlussprojekt 2023");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}