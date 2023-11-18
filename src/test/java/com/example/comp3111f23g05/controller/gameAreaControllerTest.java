package com.example.comp3111f23g05.controller;

import com.example.comp3111f23g05.manager.SceneManager;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class gameAreaControllerTest extends ApplicationTest {

    gameAreaController controller = new gameAreaController();
    @Override
    public void start(Stage stage) {
        // Create a simple JavaFX application with a button
        SceneManager.getInstance().init(stage);
    }
    @Test
    public void accessorTest(){
        controller.getBackground(); // target function
        controller.getMapArea(); // target function
        controller.getFunctionalButton(); // target function
        controller.getReturnHomeButton(); // target function
    }

    @Test
    public void homeButtonTest(){
        Platform.runLater(() -> {
            SceneManager.getInstance().toGame();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clickOn("Home");// target function
            sleep(300);

            SceneManager.getInstance().toShortestPath();
            sleep(300);
            clickOn("Home");// target function
            sleep(300);

            SceneManager.getInstance().toEditor();
            SceneManager.getInstance().toEditor();
            sleep(300);
            clickOn("Home");// target function
            sleep(300);

            SceneManager.getInstance().toGameOver(true);
            sleep(300);
            clickOn("Home");// target function
            sleep(300);
        });

    }

}