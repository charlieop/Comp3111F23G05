package com.example.comp3111f23g05.manager;

import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class SceneManagerTest extends ApplicationTest {
    Stage stage;
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        SceneManager.getInstance().init(stage);
    }

    @Test
    public void getInstanceTest() {
        SceneManager.getInstance(); // target function
    }

    @Test
    public void initTest() {
        Platform.runLater(() -> {
            SceneManager.getInstance().init(stage); // target function
        });
    }

    @Test
    public void toIndexTest() {
        SceneManager.getInstance().toIndex(); // target function
    }
    @Test
    public void toEditorTest() {
        Platform.runLater(() -> {
            SceneManager.getInstance().toEditor(); // target function
        });
    }
    @Test
    public void toGameTest() {
        SceneManager.getInstance().toGame(); // target function
    }
    @Test
    public void toShortestPathTest() {
        SceneManager.getInstance().toShortestPath(); // target function
    }
    @Test
    public void toGameOverTest() {
        SceneManager.getInstance().toGameOver(true); // target function
        SceneManager.getInstance().toGameOver(false); // target function
    }
}