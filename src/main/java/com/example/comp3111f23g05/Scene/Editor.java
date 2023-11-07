package com.example.comp3111f23g05.Scene;

import com.example.comp3111f23g05.Manager.SceneManager;
import com.example.comp3111f23g05.Map.Map;
import com.example.comp3111f23g05.Map.MapGUI;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Editor {
    public static void init(Stage stage) {
        Parent root = null;
        Button btn = new Button("Home");
        btn.setOnMouseClicked(mouseEvent -> {
            SceneManager.getInstance().toIndex();});
        Map map = new Map();
        MapGUI gui = new MapGUI(map);
        HBox hbox = new HBox(gui, btn);
        root = hbox;
        stage.getScene().setRoot(root);
    }

}
