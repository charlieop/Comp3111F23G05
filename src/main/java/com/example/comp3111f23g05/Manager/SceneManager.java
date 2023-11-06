package com.example.comp3111f23g05.Manager;

import com.example.comp3111f23g05.Map.Coordinate;
import com.example.comp3111f23g05.Map.Map;
import com.example.comp3111f23g05.Map.MapGUI;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SceneManager {
    public static final int BLOCK_SIZE = 20;
    public static final int WIDTH = Math.max(900, BLOCK_SIZE * Map.MAP_SIZE);
    public static final int HEIGHT = Math.max(600, BLOCK_SIZE * Map.MAP_SIZE);
    private static final SceneManager instance = new SceneManager();

    private SceneManager() {}

    public static SceneManager getInstance() {
        return instance;
    }

    public void init(Stage stage) {
        AnchorPane root = new AnchorPane();
        Map map = new Map();
        Coordinate[] path = new Coordinate[3];
        path[0] = new Coordinate(0, 0);
        path[1] = new Coordinate(0, 1);
        path[2] = new Coordinate(1, 1);
        MapGUI grid = new MapGUI(map, path);
        grid.setTranslateX(150);
        root.getChildren().add(grid);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setTitle("Tom & Jerry Maze Game - G05");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
