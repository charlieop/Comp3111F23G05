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
    @Override
    public void start(Stage stage) {
        SceneManager.getInstance().init(stage);
    }
    @Test
    public void getBackgroundTest(){
        gameAreaController controller = new gameAreaController();
        controller.getBackground(); // target function
    }

    @Test
    public void getMapAreaTest(){
        gameAreaController controller = new gameAreaController();
        controller.getMapArea(); // target function
    }

    @Test
    public void getFunctionalButtonTest(){
        gameAreaController controller = new gameAreaController();
        controller.getFunctionalButton(); // target function
    }

    @Test
    public void getReturnHomeButtonTest(){
        gameAreaController controller = new gameAreaController();
        controller.getReturnHomeButton(); // target function
    }

    @Test
    public void homeButtonTest(){

        // "Home" button in Editor scene is override, tested under EditorTest

        // "Home" button in Game scene is override, tested under GameSceneTest

        // "Home" button in ShortestPath scene
        SceneManager.getInstance().toShortestPath();
        sleep(300);
        clickOn("Home");// target function
        sleep(300);

        //"Home" button in GameOver scene
        SceneManager.getInstance().toGameOver(true);
        sleep(2000);
        clickOn("Home");// target function
        sleep(300);

    }

}