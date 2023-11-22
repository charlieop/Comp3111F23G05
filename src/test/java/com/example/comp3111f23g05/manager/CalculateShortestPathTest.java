package com.example.comp3111f23g05.manager;

import com.example.comp3111f23g05.map.Coordinate;
import com.example.comp3111f23g05.map.Map;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;

public class CalculateShortestPathTest extends ApplicationTest {
    GameManager gameManager = GameManager.getInstance();

    //Specification
    // There are two methods that are responsible to find the shortest path,
    // they have the same name, CalculateShortestPath(), but different accessibility and parameter list.
    // This design is to enable the usage of a array that can be kept updating in the recursive calls.
    // The public one is served as an interface for method calling,
    // and the private one is main method to find the path.
    // Since they are closely related and responsible for the same functionality, we test they as a whole

    @Test
    public void SpecialTestCase() {
        Map map = new Map();
        // all four are target functions

        //Boundary cases
        Coordinate[] noPath = gameManager.CalculateShortestPath(map, new Coordinate(7, 5), new Coordinate(6, 1));
        assertEquals(0, noPath.length);
        Coordinate[] path1 = gameManager.CalculateShortestPath(map, new Coordinate(1, 4), new Coordinate(1, 4));
        assertEquals(1, path1.length);
        //invalid start and end
        Coordinate[] BarrierStart = gameManager.CalculateShortestPath(map, new Coordinate(2, 5), new Coordinate(2, 8));
        assertEquals(0, BarrierStart.length);
        Coordinate[] BarrierEnd = gameManager.CalculateShortestPath(map, new Coordinate(28, 1), new Coordinate(25, 2));
        assertEquals(0, BarrierEnd.length);

    }

    @Test
    public void TypicalTestCase() {
        Map map = new Map();

        Coordinate[] randomPath1 = gameManager.CalculateShortestPath(map, new Coordinate(15, 7), new Coordinate(6, 16));
        assertEquals(19, randomPath1.length);

        Coordinate[] randomPath2 = gameManager.CalculateShortestPath(map, new Coordinate(15, 28), new Coordinate(28, 1));
        assertEquals(51, randomPath2.length);

        Coordinate[] randomPath3 = gameManager.CalculateShortestPath(map, new Coordinate(4, 16), new Coordinate(26, 13));
        assertEquals(34, randomPath3.length);

        Coordinate[] EntryToExit = gameManager.CalculateShortestPath(map, map.entryPos, map.exitPos);
        assertEquals(61, EntryToExit.length);
    }
}