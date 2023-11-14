package com.example.comp3111f23g05.manager;

import com.example.comp3111f23g05.map.Coordinate;
import com.example.comp3111f23g05.map.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculateShortestPathTest {
    Map map = new Map();
    GameManager gameManager = GameManager.getInstance();

    //Specification
    // There are two methods that are responsible to find the shortest path,
    // they have the same name, ClaculateShortestPath, but different accessibility and parameter list.
    // This design is to enable the usage of a array that can be kept updating in the recursive calls.
    // The public one is served as an interface for method calling,
    // and the private one is main method to find the path.
    // Since they are closely related and responsible for the same functionality, we test they as a whole

    @Test
    void SpecialTestCase() {

        // all four are target functions

        //Boundary cases
        Coordinate[] noPath = gameManager.CalculateShortestPath(map, new Coordinate(0, 12), new Coordinate(4, 1));
        assertEquals(0, noPath.length);
        Coordinate[] path1 = gameManager.CalculateShortestPath(map, new Coordinate(0, 12), new Coordinate(0, 12));
        assertEquals(1, path1.length);
        //invalid start and end
        Coordinate[] BarrierStart = gameManager.CalculateShortestPath(map, new Coordinate(0, 11), new Coordinate(0, 12));
        assertEquals(0, BarrierStart.length);
        Coordinate[] BarrierEnd = gameManager.CalculateShortestPath(map, new Coordinate(0, 12), new Coordinate(4, 15));
        assertEquals(0, BarrierEnd.length);

    }

    @Test
    void TypicalTestCase() {
        Coordinate[] randomPath1 = gameManager.CalculateShortestPath(map, new Coordinate(7, 1), new Coordinate(6, 16));
        assertEquals(23, randomPath1.length);
        Coordinate[] randomPath2 = gameManager.CalculateShortestPath(map, new Coordinate(8, 28), new Coordinate(20, 28));
        assertEquals(49, randomPath2.length);
        Coordinate[] randomPath3 = gameManager.CalculateShortestPath(map, new Coordinate(4, 16), new Coordinate(26, 13));
        assertEquals(46, randomPath3.length);
        Coordinate[] EntryToExit = gameManager.CalculateShortestPath(map, map.entryPos, map.exitPos);
        assertEquals(56, EntryToExit.length);
    }
}