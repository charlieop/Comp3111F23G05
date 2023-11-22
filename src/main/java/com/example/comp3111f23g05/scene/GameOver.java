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

public class GameOver {

    /**
     * Initializes the map editor with the specified stage and file name.
     *
     * @param stage     The primary stage of the JavaFX application.
     * @param fileName  The name of the FXML file for the scene.
     * @param isWinner  Determine if the player wins.
     */
    public static void init(Stage stage, String fileName ,boolean isWinner) {
        AudioManager.getInstance().stop(Sound.GAME);
        AudioManager.getInstance().stop(Sound.THEME);

        if(isWinner){
            AudioManager.getInstance().play(Sound.VICTORY, false);
        }
        else {
            AudioManager.getInstance().play(Sound.FAILURE, false);
        }

        Parent root = null;
        Map map = new Map("MazeMap.csv");
        Coordinate[] path = GameManager.getInstance().CalculateShortestPath(map, map.entryPos, map.exitPos);
        MapGUI gui = new MapGUI(map, path);
        FXMLLoader loader = new FXMLLoader(ShortestPath.class.getResource(fileName));
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
