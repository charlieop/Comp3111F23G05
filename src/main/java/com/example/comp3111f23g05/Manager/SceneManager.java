package com.example.comp3111f23g05.Manager;

import com.example.comp3111f23g05.Map.Map;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SceneManager {
    public static final int BLOCK_SIZE = 30;
    public static final int WIDTH = Math.max(1200, BLOCK_SIZE * Map.MAP_SIZE);
    public static final int HEIGHT = 900;
    private static final SceneManager instance = new SceneManager();

    private SceneManager() {}

    public static SceneManager getInstance() {
        return instance;
    }

    public void init(Stage stage) {
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setTitle("Tom & Jerry Maze Game - G05");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
