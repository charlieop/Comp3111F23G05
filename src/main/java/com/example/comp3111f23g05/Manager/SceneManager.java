package com.example.comp3111f23g05.Manager;

import com.example.comp3111f23g05.Map.Map;
import com.example.comp3111f23g05.Scene.Index;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SceneManager {
    public static final int BLOCK_SIZE = 20;
    public static final int WIDTH = Math.max(900, BLOCK_SIZE * Map.MAP_SIZE);
    public static final int HEIGHT = Math.max(600, BLOCK_SIZE * Map.MAP_SIZE);
    private static final SceneManager instance = new SceneManager();

    private Stage stage;

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
        this.stage = stage;
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        toIndex();
        stage.show();
    }

    public void toIndex(){
        Index.load(stage);
    }

}