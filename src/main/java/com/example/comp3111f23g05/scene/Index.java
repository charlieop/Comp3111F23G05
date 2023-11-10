package com.example.comp3111f23g05.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Index {

    public static void init(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(Index.class.getResource("/fxml/index.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.getIcons().add(new Image(String.valueOf(Index.class.getResource("/images/icon.jpg"))));
        stage.getScene().setRoot(root);
    }

}
