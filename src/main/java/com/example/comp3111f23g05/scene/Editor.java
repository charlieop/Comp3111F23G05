package com.example.comp3111f23g05.scene;

import com.example.comp3111f23g05.controller.gameAreaController;
import com.example.comp3111f23g05.manager.AudioManager;
import com.example.comp3111f23g05.manager.GameManager;
import com.example.comp3111f23g05.manager.SceneManager;
import com.example.comp3111f23g05.manager.Sound;
import com.example.comp3111f23g05.map.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * The Editor class provides functionality for the map editor in the maze game.
 * It allows users to edit and save maps, clear the map, and return to the main menu.
 */

public class Editor {
    public static Map curMap;
    private static int lastX = -1;
    private static int lastY = -1;
    private static int initX = -1;
    private static int initY = -1;
    private static boolean inDrag = false;

    private static boolean visited = false;

    /**
     * Initializes the map editor with the specified stage and file name.
     *
     * @param stage     The primary stage of the JavaFX application.
     * @param fileName  The name of the FXML file for the editor scene.
     */
    public static void init(Stage stage, String fileName) {
        Parent root = null;
        Map map = new Map();
        curMap = map;
        MapGUI gui = new MapGUI(map, new Coordinate[0]);
        FXMLLoader loader = new FXMLLoader(Editor.class.getResource(fileName));
        try {
            root = loader.load();
        } catch (Exception ignored) {
            System.out.println("There is an error in the Editor Scene");
            return;
        }
        gameAreaController controller = loader.getController();

        Button clearMapButton = controller.getFunctionalButton();
        clearMapButton.setText("ClearMap");
        clearMapButton.setOnAction(Editor::clearMap);

        Button returnHome = controller.getReturnHomeButton();
        returnHome.setOnAction(Editor::returnHome);

        StackPane stack = controller.getMapArea();
        stack.getChildren().add(gui);

        // handle click on Barrier and Clear block
        gui.setOnMouseClicked(Editor::handleMouseClicked);

        // handle drag to edit map
        gui.setOnMouseDragged(Editor::handleMouseDragged);

        stage.getScene().setRoot(root);

        if (!visited) {
            visited = true;
            AudioManager.getInstance().play(Sound.ALERT, false);
            Alert guide = new Alert(Alert.AlertType.INFORMATION);
            guide.setTitle("Guide on Map Editor");
            guide.setHeaderText("Here is how to use the Map Editor");
            guide.setContentText("1. Click or drag on any block to change its type.\n2. Drag on entry or exit block to change its position.");
            guide.show();
        }
    }

    /**
     * Handles the action when the "ClearMap" button is clicked.
     *
     * @param actionEvent The action event triggered by the button click.
     */
    private static void clearMap (ActionEvent actionEvent) {
        //sound effect
        AudioManager.getInstance().play(Sound.ALERT, false);

        Alert clearMap = new Alert(Alert.AlertType.WARNING);
        clearMap.setTitle("About to Clear map...");
        clearMap.setHeaderText("Do you want to clear the map?");
        clearMap.setContentText("The map will become EMPTY.\nALL of your progress will be LOST!");
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
    }

    /**
     * Handles the action when the "Return Home" button is clicked.
     *
     * @param actionEvent The action event triggered by the button click.
     */
    private static void returnHome (ActionEvent actionEvent) {
        //sound effect
        AudioManager.getInstance().play(Sound.ALERT, false);

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
            if (path.length == 0 || !hasMultiplePath) {
                //sound effect
                AudioManager.getInstance().play(Sound.ALERT,false);

                Alert warning = new Alert(Alert.AlertType.WARNING);
                warning.setTitle("Save map Failed");
                warning.setHeaderText("There must be at least 2 path from entry to exit!");
                warning.setContentText("Please adjust the Entry/Exit position or remove some barriers.");
                warning.show();
                return;
            }
            curMap.saveMap();
            SceneManager.getInstance().toIndex();
        });
    }

    /**
     * Handles the action when the mouse is clicked on the game area.
     *
     * @param mouseEvent The mouse event triggered by the click.
     */
    private static void handleMouseClicked (MouseEvent mouseEvent) {
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

        if (Coordinate.checkX(x) && Coordinate.checkY(y)) {
            Block selected = curMap.getMap()[y][x];
            if (selected.getType() == BlockType.BARRIER){
                selected.setType(BlockType.CLEAR);
                //sound effect
                AudioManager.getInstance().play(Sound.BLOCK,false);
            } else if (selected.getType() == BlockType.CLEAR) {
                selected.setType(BlockType.BARRIER);
                //sound effect
                AudioManager.getInstance().play(Sound.BLOCK,false);
            }
        }
    }

    /**
     * Handles the action when the mouse is dragged on the game area.
     *
     * @param mouseEvent The mouse event triggered by the drag.
     */
    private static void handleMouseDragged (MouseEvent mouseEvent) {
        int x = (int)mouseEvent.getX() / SceneManager.BLOCK_SIZE;
        int y = (int)mouseEvent.getY() / SceneManager.BLOCK_SIZE;

        // prevent drag the mouse outside the grid
        if (!Coordinate.checkY(y) || !Coordinate.checkX(x)){
            return;
        }
        Block selected = curMap.getMap()[y][x];
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
        Block initBlock = curMap.getMap()[initY][initX];
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
            Block newPos = curMap.getMap()[y][x];
            if (newPos.getType() == BlockType.BOUNDARY) {

                newPos.setType(initType==BlockType.ENTRY ? BlockType.ENTRY : BlockType.EXIT);
                initBlock.setType(BlockType.BOUNDARY);
                initX = x;
                initY = y;
                if (initType == BlockType.ENTRY){
                    curMap.entryPos = new Coordinate(x, y);
                    //sound effect
                    AudioManager.getInstance().play(Sound.BLOCK, false);
                } else {
                    curMap.exitPos = new Coordinate(x, y);
                    //sound effect
                    AudioManager.getInstance().play(Sound.BLOCK, false);
                }
            }

            // handle change between clear and barrier
        } else {
            if (selected.getType() == BlockType.BARRIER) {
                selected.setType(BlockType.CLEAR);
                //sound effect
                AudioManager.getInstance().play(Sound.BLOCK, false);
            } else if (selected.getType() == BlockType.CLEAR) {
                selected.setType(BlockType.BARRIER);
                //sound effect
                AudioManager.getInstance().play(Sound.BLOCK, false);
            }
        }
    }
}
