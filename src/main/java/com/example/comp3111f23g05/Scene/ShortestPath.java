package com.example.comp3111f23g05.Scene;

import com.example.comp3111f23g05.Manager.GameManager;
import com.example.comp3111f23g05.Manager.SceneManager;
import com.example.comp3111f23g05.Map.Coordinate;
import com.example.comp3111f23g05.Map.Map;
import com.example.comp3111f23g05.Map.MapGUI;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ShortestPath {
    public static void init(Stage stage) {
        Parent root = null;
        Button btn = new Button("Home");
        btn.setOnMouseClicked(mouseEvent -> {SceneManager.getInstance().toIndex();});
        Map map = new Map();
//        Coordinate[] path = new Coordinate[3];
//        path[0] = new Coordinate(0, 12);
//        path[1] = new Coordinate(1, 12);
//        path[2] = new Coordinate(2, 12);
//        path[3] = new Coordinate(1, 2);
//        path[4] = new Coordinate(1, 3);
//        path[5] = new Coordinate(2, 3);
//        path[6] = new Coordinate(2, 4);
//        path[7] = new Coordinate(3, 4);
//        path[8] = new Coordinate(4, 4);
//        path[9] = new Coordinate(5, 4);
        Coordinate[] path = GameManager.getInstance().CalculateShortestPath(map,new Coordinate(0,12), new Coordinate(29,1));
        MapGUI gui = new MapGUI(map, path);
        HBox hbox = new HBox(gui, btn);
        root = hbox;
        stage.getScene().setRoot(root);
    }

}
