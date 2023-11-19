package com.example.comp3111f23g05.scene;

import com.example.comp3111f23g05.controller.gameAreaController;
import com.example.comp3111f23g05.manager.AudioManager;
import com.example.comp3111f23g05.manager.GameManager;
import com.example.comp3111f23g05.manager.SceneManager;
import com.example.comp3111f23g05.manager.Sound;
import com.example.comp3111f23g05.map.Coordinate;
import com.example.comp3111f23g05.map.Map;
import com.example.comp3111f23g05.map.MapGUI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Game {
    public static void init(Stage stage) {
        AudioManager.getInstance().stop(Sound.THEME);
        AudioManager.getInstance().play(Sound.GAME,true);
        Parent root = null;
        Map map = new Map();
        MapGUI gui = new MapGUI(map, new Coordinate[0]);
        FXMLLoader loader = new FXMLLoader(Game.class.getResource("/fxml/gameArea.fxml"));
        try {
            root = loader.load();
        } catch (IOException ignored) {
        }
        GameManager.getInstance().init(root, map);
        gameAreaController controller = loader.getController();
        // more scene settings
        Button hidden = controller.getFunctionalButton();
        hidden.setVisible(false);

        Button home = controller.getReturnHomeButton();
        home.setOnAction(actionEvent -> {
            GameManager.getInstance().refresh.stop();
            AudioManager.getInstance().stop(Sound.GAME);
            SceneManager.getInstance().toIndex();
        });

        ImageView background = controller.getBackground();
        background.setImage(new Image(String.valueOf(Game.class.getResource("/images/gameTimeBackground.jpg"))));

        StackPane stack = controller.getMapArea();
        stack.getChildren().add(gui);
        Canvas canvas = GameManager.getInstance().getCanvas();
        stack.getChildren().add(canvas);
        stage.getScene().setRoot(root);
    }
}