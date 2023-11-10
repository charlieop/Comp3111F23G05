package com.example.comp3111f23g05.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockTest {
    // this is the unit test cases for class Block and also enum BlockType
    Block barrier = new Block(BlockType.BARRIER);
    Block clear = new Block(BlockType.CLEAR);
    Block entry = new Block(BlockType.ENTRY);
    Block highlight = new Block(BlockType.HIGHLIGHTED);
    @Test
    void ConstructorTest() {
        Block b = new Block(BlockType.BARRIER); // target function
        Block c = new Block(BlockType.CLEAR); // target function
        Block e = new Block(BlockType.ENTRY); // target function
        Block h = new Block(BlockType.HIGHLIGHTED); // target function
    }

    @Test
    void getTypeTest() {
        assertEquals(barrier.getType(), BlockType.BARRIER); // target function
        assertEquals(clear.getType(), BlockType.CLEAR); // target function
        assertNotEquals(clear.getType(), BlockType.ENTRY); // target function
    }

    @Test
    void setTypeAndChangeVisualTestPt1() {
        Block b = new Block(BlockType.BARRIER);
        assertEquals(b.getType(), BlockType.BARRIER);

        // target function
        // this is also a setter function for private function changeVisual(), which will only be called in this setter function.
        b.setType(BlockType.CLEAR);
        // end of target function

        assertNotEquals(b.getType(), BlockType.BARRIER);
        assertEquals(b.getType(), BlockType.CLEAR);

        // target function
        // this is also a setter function for private function changeVisual(), which will only be called in this setter function.
        b.setType(BlockType.BARRIER);
        // end of target function

        // target function
        // this is also a setter function for private function changeVisual(), which will only be called in this setter function.
        b.setType(BlockType.ENTRY);
        // end of target function

        // target function
        // this is also a setter function for private function changeVisual(), which will only be called in this setter function.
        b.setType(BlockType.EXIT);
        // end of target function
    }

    @Test
    void setTypeAndChangeVisualTestPt2() {
        Block b = new Block(BlockType.BOUNDARY);

        // target function
        // this is also a setter function for private function changeVisual(), which will only be called in this setter function.
        b.setType(BlockType.HIGHLIGHTED);
        // end of target function

        assertNotEquals(b.getType(), BlockType.BOUNDARY);
        assertEquals(b.getType(), BlockType.HIGHLIGHTED);

        // target function
        // this is also a setter function for private function changeVisual(), which will only be called in this setter function.
        b.setType(BlockType.BOUNDARY);
        // end of target function
    }

    @Test
    void reachableTest() {
        assertTrue(clear.reachable());// target function
        assertFalse(barrier.reachable());// target function
        assertTrue(entry.reachable());// target function
    }
}