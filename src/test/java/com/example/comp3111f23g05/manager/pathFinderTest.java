package com.example.comp3111f23g05.manager;

import com.example.comp3111f23g05.map.Coordinate;
import com.example.comp3111f23g05.map.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class pathFinderTest {
    Map map = new Map();

    @Test
    void BoundaryTestCase() {
        Coordinate[] path1 = GameManager.getInstance().CalculateShortestPath(map, new Coordinate(0, 12), new Coordinate(0, 12));
        assertEquals(1, path1.length);
        Coordinate[] path2 = GameManager.getInstance().CalculateShortestPath(map, new Coordinate(0, 12), new Coordinate(1, 12));
        assertEquals(2, path2.length);
        Coordinate[] noPath1 = GameManager.getInstance().CalculateShortestPath(map, new Coordinate(0, 12), new Coordinate(4, 1));
        assertEquals(0, noPath1.length);
        Coordinate[] noPath2 = GameManager.getInstance().CalculateShortestPath(map, new Coordinate(1, 7), new Coordinate(14, 1));
        assertEquals(0, noPath2.length);

    }

    @Test
    void InvalidInputTestCase() {
        // maybe no need this test case? Recursive calls will cover these cases?
        Coordinate[] BarrierStart = GameManager.getInstance().CalculateShortestPath(map, new Coordinate(0, 11), new Coordinate(0, 12));
        assertEquals(0, BarrierStart.length);
        Coordinate[] BarrierEnd = GameManager.getInstance().CalculateShortestPath(map, new Coordinate(0, 12), new Coordinate(4, 15));
        assertEquals(0, BarrierEnd.length);

    }

    @Test
    void TypicalTestCase() {
        Coordinate[] path1 = GameManager.getInstance().CalculateShortestPath(map, new Coordinate(7, 1), new Coordinate(6, 16));
        assertEquals(23, path1.length);
        Coordinate[] path2 = GameManager.getInstance().CalculateShortestPath(map, new Coordinate(20, 28), new Coordinate(28, 3));
        assertEquals(48, path2.length);
        Coordinate[] EntryToExit = GameManager.getInstance().CalculateShortestPath(map, new Coordinate(0, 12), new Coordinate(29, 1));
        assertEquals(49, EntryToExit.length);

    }
}