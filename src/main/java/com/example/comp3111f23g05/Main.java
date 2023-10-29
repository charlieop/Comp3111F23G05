package com.example.comp3111f23g05;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void init() throws Exception {
        super.init();
    }
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);

        GridPane grid = new GridPane();
        Button label;
        for (int i=0; i<30; i++) {
            for (int j = 0; j < 30; j++) {
                label = new Button("1");
                label.prefHeight(500);
                label.prefWidth(500);
                grid.add(label, i, j);
            }
        }
        System.out.println(grid.getRowCount());
        grid.prefHeight(900);
        grid.prefWidth(900);
        grid.setBackground(new Background(new BackgroundFill(Color.RED,
                CornerRadii.EMPTY,
                Insets.EMPTY)));

        Scene scene = new Scene(grid, 900, 900);
        stage.setTitle("JavaFX Game");
//        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void stop() throws Exception {
        super.stop();
    }


    public static void main(String[] args) {
        launch();
    }
}