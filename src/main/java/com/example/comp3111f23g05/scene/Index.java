package com.example.comp3111f23g05.scene;

import com.example.comp3111f23g05.manager.AudioManager;
import com.example.comp3111f23g05.manager.Sound;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.util.Objects;

public class Index {
    public static void init(Stage stage, String fileName) {
        AudioManager.getInstance().play(Sound.THEME, true);
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(Index.class.getResource(fileName)));
            stage.getScene().setRoot(root);
        } catch (Exception ignored) {
            System.out.println("there is an error in the Index Scene");
            return;
        }
    }
}
