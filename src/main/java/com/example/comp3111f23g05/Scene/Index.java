package com.example.comp3111f23g05.Scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
        stage.getScene().setRoot(root);
    }

}
