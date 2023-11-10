package com.example.comp3111f23g05.map;

import com.example.comp3111f23g05.manager.GameManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapGUITest {
    Map map = new Map();
    Coordinate[] path = GameManager.getInstance().CalculateShortestPath(map, map.entryPos, map.exitPos);
    @Test
    void constructorTest() {
        MapGUI gui = new MapGUI(map, new Coordinate[0]); // target function
        MapGUI guiWithPath = new MapGUI(map, path); // target function
    }
}