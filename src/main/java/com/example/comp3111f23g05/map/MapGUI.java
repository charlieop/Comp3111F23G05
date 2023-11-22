package com.example.comp3111f23g05.map;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * The MapGUI class represents the graphical user interface for the game map.
 * It extends the StackPane class and contains a GridPane for visualization.
 */
public class MapGUI extends StackPane {

    /**
     * The map associated with the GUI.
     */
    private final Map map;

    /**
     * The GridPane used for visualization.
     */
    private final GridPane visualization;

    /**
     * Initializes the MapGUI with the specified map and path.
     *
     * @param map  The map to be visualized.
     * @param path  The path to highlight on the map.
     */
    public MapGUI(Map map, Coordinate[] path) {
        this.map = map;
        visualization = new GridPane();
        Block[][] mapData = map.getMap();
        for (int row=0; row< mapData.length; row++) {
            for (int col=0; col<mapData[0].length; col++) {
                visualization.add(mapData[row][col], col, row);
            }
        }
        for (int i=1; i<path.length-1; i++) {
            mapData[path[i].y][path[i].x].setType(BlockType.HIGHLIGHTED);
        }
        getChildren().add(visualization);
    }
}