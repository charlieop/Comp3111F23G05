package com.example.comp3111f23g05.manager;

import com.example.comp3111f23g05.map.Map;
import com.example.comp3111f23g05.scene.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SceneManager {

    /**
     * The size of each block in the maze.
     */
    public static final int BLOCK_SIZE = 20;

    /**
     * The width of the game area.
     */
    public static final int WIDTH = Math.max(900, BLOCK_SIZE * Map.MAP_SIZE + 300);

    /**
     * The height of the game area.
     */
    public static final int HEIGHT = Math.max(600, BLOCK_SIZE * Map.MAP_SIZE);

    /**
     * The singleton instance of the SceneManager.
     */
    private static final SceneManager instance = new SceneManager();

    /**
     * The JavaFX stage.
     */
    private Stage stage;

    private SceneManager() {}

    /**
     * Returns the singleton instance of the SceneManager.
     *
     * @return The SceneManager instance.
     */
    public static SceneManager getInstance() {
        return instance;
    }

    /**
     * Initializes the JavaFX stage.
     *
     * @param stage The JavaFX stage to initialize.
     */
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
        stage.requestFocus();
        stage.toFront();
    }
    /**
     * Transitions to the Index scene.
     */
    public void toIndex(){
        Index.init(stage, "/fxml/index.fxml");
    }
    /**
     * Transitions to the Editor scene.
     */
    public void toEditor(){
        Editor.init(stage, "/fxml/gameArea.fxml");
    }
    /**
     * Transitions to the ShortestPath scene.
     */
    public void toShortestPath(){
        ShortestPath.init(stage,"/fxml/gameArea.fxml", "ShortestPathData.csv" );
    }
    /**
     * Transitions to the Game scene.
     */
    public void toGame(){
        Game.init(stage, "/fxml/gameArea.fxml");
    }
    /**
     * Transitions to the GameOver scene.
     *
     * @param isWinner True if the player won the game, false otherwise.
     */
    public void toGameOver(boolean isWinner){
        GameOver.init(stage, "/fxml/gameArea.fxml", isWinner);
    }

}
