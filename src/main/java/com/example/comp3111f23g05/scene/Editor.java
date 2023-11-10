package com.example.comp3111f23g05.scene;

import com.example.comp3111f23g05.controller.gameAreaController;
import com.example.comp3111f23g05.manager.GameManager;
import com.example.comp3111f23g05.manager.SceneManager;
import com.example.comp3111f23g05.map.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class Editor {
    private static Map curMap;
    private static int lastX = -1;
    private static int lastY = -1;
    private static int initX = -1;
    private static int initY = -1;
    private static boolean inDrag = false;
    public static void init(Stage stage) {
        Parent root = null;
        Map map = new Map();
        curMap = map;
        MapGUI gui = new MapGUI(map, new Coordinate[0]);
        FXMLLoader loader = new FXMLLoader(Editor.class.getResource("/fxml/gameArea.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gameAreaController controller = loader.getController();

        Button clearMapButton = controller.getFunctionalButton();
        clearMapButton.setText("ClearMap");
        clearMapButton.setOnAction(actionEvent -> {
            Alert clearMap = new Alert(Alert.AlertType.WARNING);
            clearMap.setTitle("About to Clear map...");
            clearMap.setHeaderText("Do you want to clear the map?");
            clearMap.setContentText("ALL of your progress will be LOST!");
            clearMap.getButtonTypes().clear();
            clearMap.getButtonTypes().add(ButtonType.CANCEL);
            clearMap.getButtonTypes().add(ButtonType.YES);
            clearMap.showAndWait().ifPresent(response -> {
                if (response.getButtonData() == ButtonBar.ButtonData.CANCEL_CLOSE) {
                    return;
                }

                // if user agreed to clear the map
                for (int row = 1; row < Map.MAP_SIZE-1; row++) {
                    for (int col = 1; col < Map.MAP_SIZE-1; col++) {
                        curMap.getMap()[row][col].setType(BlockType.CLEAR);
                    }
                }
            });
        });

        Button returnHome = controller.getReturnHomeButton();
        returnHome.setOnAction(actionEvent -> {
            Alert saveMap = new Alert(Alert.AlertType.NONE);
            saveMap.setTitle("About to exit Map Editor...");
            saveMap.setHeaderText("Do you want to save the map?");
            saveMap.setContentText("If you choose \"NO\", all of your process will be LOST!");
            saveMap.getButtonTypes().add(ButtonType.NO);
            saveMap.getButtonTypes().add(ButtonType.CLOSE);
            saveMap.getButtonTypes().add(ButtonType.YES);
            saveMap.showAndWait().ifPresent(response -> {
                if (response.getButtonData() == ButtonBar.ButtonData.NO) {
                    SceneManager.getInstance().toIndex();
                    return;
                } else if (response.getButtonData() == ButtonBar.ButtonData.CANCEL_CLOSE) {
                    return;
                }

                // check save map condition: at least 2 path
                Coordinate[] path = GameManager.getInstance().CalculateShortestPath(curMap, curMap.entryPos, curMap.exitPos);
                boolean hasMultiplePath = false;
                Coordinate[] anotherPath;
                for (int i = 1; i < path.length-1; i++) {
                    curMap.getMap()[path[i].y][path[i].x].setType(BlockType.BARRIER);
                    anotherPath = GameManager.getInstance().CalculateShortestPath(curMap, curMap.entryPos, curMap.exitPos);
                    curMap.getMap()[path[i].y][path[i].x].setType(BlockType.CLEAR);
                    if (anotherPath.length != 0) {
                        hasMultiplePath = true;
                        break;
                    }
                }
                if (path.length == 0 || !hasMultiplePath){
                    Alert warning = new Alert(Alert.AlertType.WARNING);
                    warning.setTitle("Save map Failed");
                    warning.setHeaderText("There must be at least 2 path from entry to exit!");
                    warning.setContentText("Please adjust the Entry/Exit position or remove some barriers.");
                    warning.show();
                    return;
                }
                map.saveMap();
                SceneManager.getInstance().toIndex();
            });
        });

        Text text = controller.getInfoText();
        text.setText("Editor");

        StackPane stack = controller.getMapArea();
        stack.getChildren().add(gui);

        // handle click on Barrier and Clear block
        gui.setOnMouseClicked(mouseEvent -> {
            int x = (int)mouseEvent.getX() / SceneManager.BLOCK_SIZE;
            int y = (int)mouseEvent.getY() / SceneManager.BLOCK_SIZE;

            // cancel the mouse button release after drag
            initX = initY = -1;
            if (inDrag && lastX==x && lastY==y){
                inDrag = false;
                lastX = lastY = -1;
                return;
            }
            inDrag = false;

            Block selected = map.getMap()[y][x];
            if (selected.getType() == BlockType.BARRIER){
                selected.setType(BlockType.CLEAR);
            } else if (selected.getType() == BlockType.CLEAR) {
                selected.setType(BlockType.BARRIER);
            }
        });

        // handle drag to edit map
        gui.setOnMouseDragged(mouseEvent -> {
            int x = (int)mouseEvent.getX() / SceneManager.BLOCK_SIZE;
            int y = (int)mouseEvent.getY() / SceneManager.BLOCK_SIZE;

            // prevent drag the mouse outside the grid
            if (!Coordinate.checkY(y) || !Coordinate.checkX(x)){
                return;
            }
            Block selected = map.getMap()[y][x];
            // check if drag started
            if (!inDrag) {
                initX = x;
                initY = y;
            }
            inDrag = true;

            // prevent from change the same block multiple times
            if (lastX==x && lastY==y){
                return;
            }
            lastX = x;
            lastY = y;
            Block initBlock = map.getMap()[initY][initX];
            BlockType initType = initBlock.getType();
            // move entry and exit point
            if (initType == BlockType.ENTRY || initType == BlockType.EXIT) {
                // find the closest boundary
                double threshlod = ((double) Map.MAP_SIZE-1)/2;
                double x_dist = Math.abs((double)x - threshlod);
                double y_dist = Math.abs((double)y - threshlod);
                if (x_dist > y_dist) {
                    x = x < threshlod ? 0 : Map.MAP_SIZE-1;
                } else {
                    y = y < threshlod ? 0 : Map.MAP_SIZE-1;
                }
                // change entry exit position
                Block newPos = map.getMap()[y][x];
                if (newPos.getType() == BlockType.BOUNDARY) {
                    newPos.setType(initType==BlockType.ENTRY ? BlockType.ENTRY : BlockType.EXIT);
                    initBlock.setType(BlockType.BOUNDARY);
                    initX = x;
                    initY = y;
                    if (initType == BlockType.ENTRY){
                        map.entryPos = new Coordinate(x, y);
                    } else {
                        map.exitPos = new Coordinate(x, y);
                    }
                }

            // handle change between clear and barrier
            } else {
                if (selected.getType() == BlockType.BARRIER) {
                    selected.setType(BlockType.CLEAR);
                } else if (selected.getType() == BlockType.CLEAR) {
                    selected.setType(BlockType.BARRIER);
                }
            }
        });

        stage.getScene().setRoot(root);
    }
}
