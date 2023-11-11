package com.example.comp3111f23g05.scene;

import com.example.comp3111f23g05.controller.gameAreaController;
import com.example.comp3111f23g05.manager.GameManager;
import com.example.comp3111f23g05.map.Coordinate;
import com.example.comp3111f23g05.map.Map;
import com.example.comp3111f23g05.map.MapGUI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Game {
    public static void init(Stage stage, Map map) {
        Parent root = null;
        MapGUI gui = new MapGUI(map, new Coordinate[0]);
        FXMLLoader loader = new FXMLLoader(Game.class.getResource("/fxml/gameArea.fxml"));
        try {
            root = loader.load();
        } catch (IOException ignored) {
        }
        gameAreaController controller = loader.getController();
        // more scene settings
        Button pause = controller.getFunctionalButton();
        pause.setText("Pause");
        Text text = controller.getInfoText();
        text.setText("Game");

        StackPane stack = controller.getMapArea();
        stack.getChildren().add(gui);
        Canvas canvas = GameManager.getInstance().getCanvas();
        stack.getChildren().add(canvas);
        stage.getScene().setRoot(root);
    }
}