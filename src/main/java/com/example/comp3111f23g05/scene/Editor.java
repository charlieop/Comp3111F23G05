package com.example.comp3111f23g05.scene;

import com.example.comp3111f23g05.controller.gameAreaController;
import com.example.comp3111f23g05.map.Map;
import com.example.comp3111f23g05.map.MapGUI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class Editor {
    public static void init(Stage stage) {
        Parent root = null;
        Map map = new Map();
        MapGUI gui = new MapGUI(map);
        FXMLLoader loader = new FXMLLoader(Editor.class.getResource("/fxml/gameArea.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gameAreaController controller = loader.getController();

        Button save = controller.getFunctionalButton();
        save.setText("Save");

        Text text = controller.getInfoText();
        text.setText("Editor");

        ImageView background = controller.getBackground();
        Image backImage = new Image(Editor.class.getResourceAsStream("/images/mapPathBackground.png"));
        background.setImage(backImage);

        StackPane stack = controller.getMapArea();
        stack.getChildren().add(gui);

        stage.getScene().setRoot(root);
    }

}
