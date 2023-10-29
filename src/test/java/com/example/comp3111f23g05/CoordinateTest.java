package com.example.comp3111f23g05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    void testBound() {
        Coordinate a = new Coordinate(0, 30);
        assertThrows(RuntimeException.class, ()->{Coordinate b = new Coordinate(-1, 0);});
        assertThrows(RuntimeException.class, ()->{Coordinate c = new Coordinate(3, 31);});
        Coordinate d = new Coordinate();
    }

    @Test
    void testCheck() {
        assertTrue(Coordinate.checkX(10));
        assertTrue(Coordinate.checkX(0));
        assertFalse(Coordinate.checkX(-1));
        assertFalse(Coordinate.checkX(31));
        assertTrue(Coordinate.checkY(10));
        assertTrue(Coordinate.checkY(0));
        assertFalse(Coordinate.checkY(-1));
        assertFalse(Coordinate.checkY(31));
    }

    @Test
    void testSet() {
        Coordinate a = new Coordinate();
        a.setX(30);
        a.setY(20);
        assertEquals(30, a.getX());
        assertEquals(20, a.getY());
        assertThrows(RuntimeException.class, ()->{a.setX(-3);});
        assertThrows(RuntimeException.class, ()->{a.setX(31);});
        assertThrows(RuntimeException.class, ()->{a.setY(-3);});
        assertThrows(RuntimeException.class, ()->{a.setY(32);});
    }

    @Test
    void testComp() {
        Coordinate a = new Coordinate();
        Coordinate b = new Coordinate();
    }

    @Test
    void testEquals() {
        Coordinate a = new Coordinate();
        Coordinate b = new Coordinate();
        assertTrue(a.equals(b));
        assertTrue(b.equals(a));
        a.setY(10);
        assertFalse(b.equals(a));
        b.setY(10);
        assertTrue(a.equals(b));
    }

    @Test
    void testDist() {
        Coordinate a = new Coordinate();
        Coordinate b = new Coordinate();
        assertEquals(0, a.calDistWith(b));
        a.setY(10);
        assertEquals(10, a.calDistWith(b));
        b.setX(30);
        assertEquals(40, b.calDistWith(a));
    }
}