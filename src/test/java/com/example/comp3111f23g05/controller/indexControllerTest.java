package com.example.comp3111f23g05.controller;

import com.example.comp3111f23g05.manager.SceneManager;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class indexControllerTest extends ApplicationTest {

    @Override
    public void start(Stage stage) {
        // Create a simple JavaFX application with a button
        SceneManager.getInstance().init(stage);
    }

    @Test
    public void mouseEnterMapCustomizationTest() {
        Platform.runLater(() -> {
            SceneManager.getInstance().toIndex();
            moveTo("Edit Map"); // target function
        });
    }
    @Test
    public void mouseClickedMapCustomizationTest() {
        SceneManager.getInstance().toIndex();
        clickOn("Edit Map"); // target function
    }
    @Test
    public void mouseEnteredShortestPathTest() {
        Platform.runLater(() -> {
            SceneManager.getInstance().toIndex();
            moveTo("Display Shortest Path"); // target function
        });
    }
    @Test
    public void mouseCLickedShortestPathTest() {
        SceneManager.getInstance().toIndex();
        clickOn("Display Shortest Path"); // target function
    }
    @Test
    public void mouseEnteredStartGameTest() {
        Platform.runLater(() -> {
            SceneManager.getInstance().toIndex();
            moveTo("Start Game"); // target function
        });
    }
    @Test
    public void mouseClickedStartGameTest() {
        SceneManager.getInstance().toIndex();
        clickOn("Start Game"); // target function
    }
}