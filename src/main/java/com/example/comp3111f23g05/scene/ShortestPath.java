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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ShortestPath {
    private static final int MAX_CSV_ROW = 10;
    public static void init(Stage stage, String fxmlName, String CSVName) {
        Parent root = null;
        Map map = new Map();
        Coordinate[] path = GameManager.getInstance().CalculateShortestPath(map, map.entryPos, map.exitPos);
        MapGUI gui = new MapGUI(map, path);
        FXMLLoader loader = new FXMLLoader(ShortestPath.class.getResource(fxmlName));
        try {
            root = loader.load();
        } catch (Exception ignored) {
            System.out.println("There is an error in the ShortestPath Scene.");
            return;
        }
        gameAreaController controller = loader.getController();

        Button generate = controller.getFunctionalButton();
        generate.setText("Generate CSV");
        generate.setOnAction(actionEvent -> {
            boolean res = GeneratePathCSV(CSVName, path);

            //sound effect
            AudioManager.getInstance().play(Sound.ALERT, false);

            Alert PathData = new Alert(Alert.AlertType.INFORMATION);
            PathData.setTitle("Generate Path Data CSV");
            if(res){
                PathData.setHeaderText("CSV file is successfully generated.");
                PathData.setContentText("Please find it at: /target/classes/ShortestPathData.csv");
            }
            else {
                PathData.setHeaderText("Fail to generate CSV file!");
            }
            PathData.getButtonTypes().clear();
            PathData.getButtonTypes().add(ButtonType.OK);
            PathData.showAndWait();
        });

        StackPane stack = controller.getMapArea();
        stack.getChildren().add(gui);

        stage.getScene().setRoot(root);
    }

    private static boolean GeneratePathCSV(String fileName, Coordinate[] ShortestPath){
        URL res = ShortestPath.class.getClassLoader().getResource(fileName);
        String FilePath = null;
        try {
            assert res != null;
            FilePath = new File(res.toURI()).getAbsolutePath();
            String str = "";
            String title1 = "Path length:  " + ShortestPath.length + "," + "\n";
            String title2 = "display format: (row-col)" + "," + "\n";
            str += title1 + title2;
            int c = 0;
            for (Coordinate step : ShortestPath){
                str += " (" + step.y + "-" + step.x + ") " + ","; //(y,x) = (row, col)
                if (++c == MAX_CSV_ROW){
                    c = 0;
                    str += "\n";
                }
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(FilePath));
            writer.write(str);
            writer.close();
        } catch (Exception ignored) {
            System.out.println("There is an error when generating PathCSV.");
            return false;
        }
        return true;
    }

}
