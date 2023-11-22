package com.example.comp3111f23g05.manager;

import com.example.comp3111f23g05.map.Map;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class GameManagerTest extends ApplicationTest {
    Parent rootTest;
    public Map mapTest;

    @Override
    public void start(javafx.stage.Stage stage) {
        rootTest = new AnchorPane();
        mapTest = new Map(); // You may need to create a test map instance with proper data
    }

    @Test
    public void gameGetInstanceTest() {
        GameManager.getInstance(); // target function
    }
    @Test
    public void gameInitTest() {
        javafx.application.Platform.runLater(() -> {
            GameManager.getInstance().init(rootTest, mapTest); // target function
        });
    }

}