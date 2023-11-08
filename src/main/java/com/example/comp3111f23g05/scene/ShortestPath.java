package com.example.comp3111f23g05.scene;

import com.example.comp3111f23g05.controller.gameAreaController;
import com.example.comp3111f23g05.manager.GameManager;
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

public class ShortestPath {
    public static void init(Stage stage) {
        Parent root = null;
        Map map = new Map();
        Coordinate[] path = GameManager.getInstance().CalculateShortestPath(map, map.getEntryPos(), map.getExitPos());
        MapGUI gui = new MapGUI(map, path);
        FXMLLoader loader = new FXMLLoader(ShortestPath.class.getResource("/fxml/gameArea.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gameAreaController controller = loader.getController();

        Button generate = controller.getFunctionalButton();
        generate.setText("Generate");

        Text text = controller.getInfoText();
        text.setText("Find Path");

        StackPane stack = controller.getMapArea();
        stack.getChildren().add(gui);

        stage.getScene().setRoot(root);
    }

}
