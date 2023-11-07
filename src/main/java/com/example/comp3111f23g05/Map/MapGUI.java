package com.example.comp3111f23g05.Map;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class MapGUI extends StackPane {
    private final Map map;
    private GridPane visualization;

    public MapGUI(Map map) {
        this.map = map;
        visualization = new GridPane();
        Block[][] mapData = map.getMap();
        for (int i=0; i<30; i++) {
            for (int j=0; j<30; j++) {
                visualization.add(mapData[i][j], i, j);
            }
        }
        getChildren().add(visualization);
    }
    public MapGUI(Map map, Coordinate[] path) {
        this.map = map;
        visualization = new GridPane();
        Block[][] mapData = map.getMap();
        for (int i=0; i<30; i++) {
            for (int j=0; j<30; j++) {
                visualization.add(mapData[i][j], i, j);
            }
        }
        for (Coordinate pos: path) {
            mapData[pos.getX()][pos.getY()].setType(BlockType.HIGHLIGHTED);
        }
        getChildren().add(visualization);
    }

}