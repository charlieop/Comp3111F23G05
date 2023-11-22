package com.example.comp3111f23g05.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    @Test
    void constructorAndLoadMapAndSetBlockTest() {
        // this is a constructor function that will call private functions to help load the map
        // it is possible to make all private methods it used as a part of code
        // the choice of making them as separated methods is for easier to understand

        Map myMap = new Map("MazeMap.csv"); // target function
        Map errorMap = new Map("");
        // note that this also includes the code coverage for private method loadMap()
        // since loadMap() is a private helper method to load map data into the object's attribute Block[][]
        //

        // note that this also includes the code coverage for private method setBlock()
        // since setBlock is a private helper method to load map data into the object's attribute Block[][]
        //
    }

    @Test
    void getMapTest() {
        Map myMap = new Map("MazeMap.csv");
        Block[][] mapdata = myMap.getMap(); // target function
        assertEquals(30, mapdata.length);
        assertEquals(30, mapdata[0].length);
    }

    @Test
    void saveMapTest() {
        Map myMap = new Map("MazeMap.csv");
        myMap.saveMap("MazeMap.csv"); // target function
        myMap.saveMap("");//target function
    }

}