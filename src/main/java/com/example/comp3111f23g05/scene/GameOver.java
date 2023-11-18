package com.example.comp3111f23g05.scene;

import com.example.comp3111f23g05.controller.gameAreaController;
import com.example.comp3111f23g05.manager.AudioManager;
import com.example.comp3111f23g05.manager.GameManager;
import com.example.comp3111f23g05.manager.Sound;
import com.example.comp3111f23g05.map.Coordinate;
import com.example.comp3111f23g05.map.Map;
import com.example.comp3111f23g05.map.MapGUI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GameOver {
    public static void init(Stage stage, String fxmlName ,boolean isWinner) {

        if(isWinner){
            AudioManager.getInstance().play(Sound.VICTORY, false);
        }
        else {
            AudioManager.getInstance().play(Sound.FAILURE, false);
        }

        Parent root = null;
        Map map = new Map();
        Coordinate[] path = GameManager.getInstance().CalculateShortestPath(map, map.entryPos, map.exitPos);
        MapGUI gui = new MapGUI(map, path);
        FXMLLoader loader = new FXMLLoader(ShortestPath.class.getResource(fxmlName));
        try {
            root = loader.load();
        } catch (Exception ignored) {
            System.out.println("There is an error in the GameOver Scene");
            return;
        }
        gameAreaController controller = loader.getController();

        Button hide = controller.getFunctionalButton();
        hide.setVisible(false);

        ImageView background = controller.getBackground();
        String imagePath = "/images/gameOver_" + ( isWinner ? "Jerry.jpg" : "Tom.jpg");
        background.setImage(new Image(GameOver.class.getResourceAsStream(imagePath)));
        background.setPreserveRatio(false);

        StackPane stack = controller.getMapArea();

        stage.getScene().setRoot(root);
    }

}
