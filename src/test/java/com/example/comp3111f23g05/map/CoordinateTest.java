package com.example.comp3111f23g05.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    void testBound() {
        Coordinate a = new Coordinate(0, 29);
        assertThrows(RuntimeException.class, ()->{Coordinate b = new Coordinate(-1, 0);});
        assertThrows(RuntimeException.class, ()->{Coordinate c = new Coordinate(3, 31);});
    }

    @Test
    void testCheck() {
        assertTrue(Coordinate.checkX(10));
        assertTrue(Coordinate.checkX(0));
        assertFalse(Coordinate.checkX(-1));
        assertFalse(Coordinate.checkX(30));
        assertTrue(Coordinate.checkY(10));
        assertTrue(Coordinate.checkY(0));
        assertFalse(Coordinate.checkY(-1));
        assertFalse(Coordinate.checkY(30));
    }


    @Test
    void testEquals() {
        Coordinate a = new Coordinate(10, 10);
        Coordinate b = new Coordinate(10, 20);
        assertFalse(a.equals(b));
        assertFalse(b.equals(a));
        assertTrue(a.equals(a));
    }

    @Test
    void testDist() {
        Coordinate a = new Coordinate(20, 20);
        Coordinate b = new Coordinate(10, 20);
        assertEquals(10, a.calDistWith(b));
    }

    @Test
    void testSurroudning() {
        Coordinate a = new Coordinate(0, 0);
        Coordinate s1 = new Coordinate(0, 1);
        Coordinate s2 = new Coordinate(1, 0);
        Coordinate[] surd = {s1, s2};
        Coordinate[] res = a.surroundings();
        assertEquals(2, res.length);
        assertTrue(res[1].equals(s1) || res[0].equals(s1));
        assertTrue(res[1].equals(s2) || res[0].equals(s2));

        a = new Coordinate(3, 3);
        res = a.surroundings();
        for (int i=0; i<res.length; i++) {
            System.out.println(res[i].x + "-" + res[i].y);
        }
    }
}