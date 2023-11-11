package com.example.comp3111f23g05.manager;

import com.example.comp3111f23g05.map.Map;
import com.example.comp3111f23g05.scene.Editor;
import com.example.comp3111f23g05.scene.Game;
import com.example.comp3111f23g05.scene.Index;
import com.example.comp3111f23g05.scene.ShortestPath;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
        this.stage = stage;
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setTitle("Tom & Jerry Maze Game - G05");
        stage.getIcons().add(new Image(String.valueOf(Index.class.getResource("/images/icon.jpg"))));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setMinHeight(HEIGHT);
        stage.setMinWidth(WIDTH);
        toIndex();
        stage.show();
    }

    public void toIndex(){
        Index.init(stage);
    }
    public void toEditor(){
        Editor.init(stage);
    }
    public void toShortestPath(){
        ShortestPath.init(stage);
    }
    public void toGame(){
        Game.init(stage);
    }


}
