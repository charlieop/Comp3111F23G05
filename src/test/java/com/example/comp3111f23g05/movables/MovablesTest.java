package com.example.comp3111f23g05.movables;

import com.example.comp3111f23g05.manager.SceneManager;
import com.example.comp3111f23g05.map.Coordinate;
import com.example.comp3111f23g05.map.Map;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovablesTest {
    Coordinate position = new Coordinate(0, 0);
    String imgNameTest = "/images/Jerry.gif";
    long speedTest = (long) (0.7 * Math.pow(10, 9));
    @Test
    public void MovableConstructorTest() {
        // testing for the constructor
        Movables jerryTest = new Movables(position, imgNameTest, speedTest); // target function
    }
    @Test
    public void MovableTest() {
        // testing for the constructor
        Movables jerryTest = new Movables(position, imgNameTest, speedTest);
        // test the paint function
        Canvas canvasTest = new Canvas();
        canvasTest.setWidth(Map.MAP_SIZE * SceneManager.BLOCK_SIZE);
        canvasTest.setHeight(Map.MAP_SIZE * SceneManager.BLOCK_SIZE);
        GraphicsContext graphicsContextTest = canvasTest.getGraphicsContext2D();
        jerryTest.paint(graphicsContextTest); // target function
    }
}