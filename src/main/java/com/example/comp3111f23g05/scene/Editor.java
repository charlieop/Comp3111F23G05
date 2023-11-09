package com.example.comp3111f23g05.scene;

import com.example.comp3111f23g05.controller.gameAreaController;
import com.example.comp3111f23g05.manager.SceneManager;
import com.example.comp3111f23g05.map.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
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
        save.setOnAction(actionEvent -> {
            map.saveMap("MazeMap.csv");
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
                int x_dist = Math.abs(x - Map.MAP_SIZE/2);
                int y_dist = Math.abs(y - Map.MAP_SIZE/2);
                if (x_dist > y_dist) {
                    x = x < Map.MAP_SIZE/2 ? 0 : Map.MAP_SIZE-1;
                } else {
                    y = y < Map.MAP_SIZE/2 ? 0 : Map.MAP_SIZE-1;
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
