package com.example.comp3111f23g05.Scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class Index implements Scene {

    public static void load(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Index.class.getResource("/fxml/index.fxml"));
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
