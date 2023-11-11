package com.example.comp3111f23g05.scene;

import com.example.comp3111f23g05.manager.AudioManager;
import com.example.comp3111f23g05.manager.Sound;
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
        } catch (IOException ignored) {
        }
        AudioManager.getInstance().play(Sound.THEME,true);
        stage.getScene().setRoot(root);
    }
}
