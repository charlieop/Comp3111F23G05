package com.example.comp3111f23g05.map;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class MapGUI extends StackPane {
    private final Map map;
    private GridPane visualization;

    public MapGUI(Map map) {
        this.map = map;
        visualization = new GridPane();
        Block[][] mapData = map.getMap();
        for (int row=0; row< mapData.length; row++) {
            for (int col=0; col<mapData[0].length; col++) {
                visualization.add(mapData[row][col], col, row);
            }
        }
        getChildren().add(visualization);
    }
    public MapGUI(Map map, Coordinate[] path) {
        this.map = map;
        visualization = new GridPane();
        Block[][] mapData = map.getMap();
        for (int row=0; row< mapData.length; row++) {
            for (int col=0; col<mapData[0].length; col++) {
                visualization.add(mapData[row][col], col, row);
            }
        }
        for (Coordinate pos: path) {
            mapData[pos.getX()][pos.getY()].setType(BlockType.HIGHLIGHTED);
        }
        getChildren().add(visualization);
    }

}