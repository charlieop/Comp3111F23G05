//package com.example.comp3111f23g05;
//
//import org.junit.jupiter.api.Test;
//import static org.junit.Assert.*;
//
//
//class BlockTest {
//    @Test
//    void testCanArrive() {
//        BlockType b = BlockType.BARRIER;
//        boolean canArriveBarrier = b.canArrive();
//        assertFalse("Barrier", canArriveBarrier);
//
//        BlockType a = BlockType.BOUNDARY;
//        boolean canArriveBoundary = a.canArrive();
//        assertFalse("Barrier", canArriveBoundary);
//
//        BlockType c = BlockType.CLEAR;
//        boolean canArriveClear = c.canArrive();
//        assertTrue("Clear", canArriveClear);
//    }
//
//    @Test
//    void testIsEntryExit() {
//        BlockType b = BlockType.BARRIER;
//        assertFalse("Barrier", b.isExit());
//        BlockType exit = BlockType.EXIT;
//        BlockType bound = BlockType.BOUNDARY;
//        assertFalse("is exit entry", exit.isEntry());
//        assertTrue("is exit exit", exit.isExit());
//        assertTrue("is bound bound", bound.isBoundary());
//    }
//}