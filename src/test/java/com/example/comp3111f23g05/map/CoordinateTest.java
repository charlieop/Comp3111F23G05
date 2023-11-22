package com.example.comp3111f23g05.map;

import org.junit.Test;

import static org.junit.Assert.*;
public class CoordinateTest {
    @Test
    public void checkXtest() {
        assertTrue(Coordinate.checkX(29)); // target function
        assertFalse(Coordinate.checkX(30)); // target function
        assertTrue(Coordinate.checkX(0)); // target function
        assertFalse(Coordinate.checkX(-1)); // target function
    }
    @Test
    public void checkYtest() {
        assertTrue(Coordinate.checkY(29)); // target function
        assertFalse(Coordinate.checkY(30)); // target function
        assertTrue(Coordinate.checkY(0)); // target function
        assertFalse(Coordinate.checkY(-1)); // target function
    }

    @Test
    public void constructorTest() {
        Coordinate a = new Coordinate(0, 29); // target function
        assertThrows(RuntimeException.class, ()->{Coordinate b = new Coordinate(-1, 0);}); // target function
        assertThrows(RuntimeException.class, ()->{Coordinate c = new Coordinate(3, 31);}); // target function
    }

    @Test
    public void testEquals() {
        Coordinate a = new Coordinate(10, 10);
        Coordinate b = new Coordinate(10, 20);
        assertFalse(a.equals(b)); // target function
        assertFalse(b.equals(a)); // target function
        assertTrue(a.equals(a)); // target function
    }

    @Test
    public void testSurroudning() {
        Coordinate a = new Coordinate(0, 0);
        Coordinate s1 = new Coordinate(0, 1);
        Coordinate s2 = new Coordinate(1, 0);
        Coordinate[] surd = {s1, s2};
        Coordinate[] res = a.surroundings(); // target function
        assertEquals(2, res.length);
        assertTrue(res[1].equals(s1) || res[0].equals(s1));
        assertTrue(res[1].equals(s2) || res[0].equals(s2));

        a = new Coordinate(3, 3);
        res = a.surroundings(); // target function
        assertEquals(4, res.length);

    }
}