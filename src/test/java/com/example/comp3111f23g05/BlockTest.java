package com.example.comp3111f23g05;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;


class VertexTest {
    @Test
    void testCanArrive() {
        Vertex b = Vertex.BARRIER;
        boolean canArriveBarrier = b.canArrive();
        assertFalse("Barrier", canArriveBarrier);

        Vertex c = Vertex.CLEAR;
        boolean canArriveClear = c.canArrive();
        assertTrue("Clear", canArriveClear);

    }

    @Test
    void testIsEntryExit() {
        Vertex b = Vertex.BARRIER;
        assertFalse("Barrier", b.isExit());
        Vertex exit = Vertex.EXIT;
        assertFalse("is exit entry", exit.isEntry());
        assertTrue("is exit exit", exit.isExit());
    }
}