package com.example.comp3111f23g05.scene;

import com.example.comp3111f23g05.controller.gameAreaController;
import com.example.comp3111f23g05.manager.GameManager;
import com.example.comp3111f23g05.manager.SceneManager;
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
        Button btn = new Button("Home");
        btn.setOnMouseClicked(mouseEvent -> {SceneManager.getInstance().toIndex();});
        Map map = new Map();
//        Coordinate[] path = new Coordinate[10];
//        path[0] = new Coordinate(0, 0);
//        path[1] = new Coordinate(0, 1);
//        path[2] = new Coordinate(1, 1);
//        path[3] = new Coordinate(1, 2);
//        path[4] = new Coordinate(1, 3);
//        path[5] = new Coordinate(2, 3);
//        path[6] = new Coordinate(2, 4);
//        path[7] = new Coordinate(3, 4);
//        path[8] = new Coordinate(4, 4);
//        path[9] = new Coordinate(5, 4);
        Coordinate[] path = GameManager.getInstance().CalculateShortestPath(map,new Coordinate(0,12), new Coordinate(29,1));
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
