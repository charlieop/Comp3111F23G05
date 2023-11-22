package com.example.comp3111f23g05.map;

import com.example.comp3111f23g05.manager.GameManager;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;


public class MapGUITest extends ApplicationTest {
    @Test
    public void constructorTest() {
        Map map = new Map("MazeMap.csv");
        Coordinate[] path = GameManager.getInstance().CalculateShortestPath(map, map.entryPos, map.exitPos);
        MapGUI gui = new MapGUI(map, new Coordinate[0]); // target function
        MapGUI guiWithPath = new MapGUI(map, path); // target function
    }
}