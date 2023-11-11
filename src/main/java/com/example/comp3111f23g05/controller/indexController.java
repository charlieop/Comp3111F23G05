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

    @FXML
    void mouseClickedMapCustomization(MouseEvent event) {
        AudioManager.getInstance().play(Sound.DONE);
        SceneManager.getInstance().toEditor();
    }

    @FXML
    void mouseClickedShortestPath(MouseEvent event) {
        AudioManager.getInstance().play(Sound.DONE);
        SceneManager.getInstance().toShortestPath();
    }

    @FXML
    void mouseClickedStartGame(MouseEvent event) {
        AudioManager.getInstance().play(Sound.DONE);
        SceneManager.getInstance().toGame();
        AudioManager.getInstance().stop();
    }

    @FXML
    void mouseEnteredMapCustomization(MouseEvent event) {
        AudioManager.getInstance().play(Sound.BUTTON);
    }

    @FXML
    void mouseEnteredShortestPath(MouseEvent event) {
        AudioManager.getInstance().play(Sound.BUTTON);
    }

    @FXML
    void mouseEnteredStartGame(MouseEvent event) {
        AudioManager.getInstance().play(Sound.BUTTON);
    }
}
