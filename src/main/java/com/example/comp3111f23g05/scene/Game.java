package com.example.comp3111f23g05.scene;

import com.example.comp3111f23g05.controller.gameAreaController;
import com.example.comp3111f23g05.map.Coordinate;
import com.example.comp3111f23g05.map.Map;
import com.example.comp3111f23g05.map.MapGUI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Game {
    public static void init(Stage stage) {
        Parent root = null;
        Map map = new Map();
        MapGUI gui = new MapGUI(map, new Coordinate[0]);
        FXMLLoader loader = new FXMLLoader(Game.class.getResource("/fxml/gameArea.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gameAreaController controller = loader.getController();

        Button pause = controller.getFunctionalButton();
        pause.setText("Pause");
        
        Text text = controller.getInfoText();
        text.setText("Game");

        StackPane stack = controller.getMapArea();
        stack.getChildren().add(gui);

        stage.getScene().setRoot(root);
    }

}
