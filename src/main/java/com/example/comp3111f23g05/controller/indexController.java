package com.example.comp3111f23g05.controller;

import com.example.comp3111f23g05.manager.AudioManager;
import com.example.comp3111f23g05.manager.SceneManager;
import com.example.comp3111f23g05.manager.Sound;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class indexController {

    @FXML
    private Button mapCustomization;

    @FXML
    private Button shortestPath;

    @FXML
    private Button startGame;

    /**
     * Event handler for the mouse clicked event on the map customization button.
     *
     * @param event The MouseEvent object representing the mouse click event.
     */
    @FXML
    void mouseClickedMapCustomization(MouseEvent event) {
        AudioManager.getInstance().play(Sound.DONE, false);
        SceneManager.getInstance().toEditor();
    }

    /**
     * Event handler for the mouse clicked event on the shortest path button.
     *
     * @param event The MouseEvent object representing the mouse click event.
     */
    @FXML
    void mouseClickedShortestPath(MouseEvent event) {
        AudioManager.getInstance().play(Sound.DONE, false);
        SceneManager.getInstance().toShortestPath();
    }

    /**
     * Event handler for the mouse clicked event on the start game button.
     *
     * @param event The MouseEvent object representing the mouse click event.
     */
    @FXML
    void mouseClickedStartGame(MouseEvent event) {
        AudioManager.getInstance().play(Sound.DONE, false);
        SceneManager.getInstance().toGame();
    }

    /**
     * Event handler for the mouse entered event on the map customization button.
     *
     * @param event The MouseEvent object representing the mouse entered event.
     */
    @FXML
    void mouseEnteredMapCustomization(MouseEvent event) {
        AudioManager.getInstance().play(Sound.BUTTON, false);
    }

    /**
     * Event handler for the mouse entered event on the shortest path button.
     *
     * @param event The MouseEvent object representing the mouse entered event.
     */
    @FXML
    void mouseEnteredShortestPath(MouseEvent event) {
        AudioManager.getInstance().play(Sound.BUTTON, false);
    }

    /**
     * Event handler for the mouse entered event on the start game button.
     *
     * @param event The MouseEvent object representing the mouse entered event.
     */
    @FXML
    void mouseEnteredStartGame(MouseEvent event) {
        AudioManager.getInstance().play(Sound.BUTTON, false);
    }
}
