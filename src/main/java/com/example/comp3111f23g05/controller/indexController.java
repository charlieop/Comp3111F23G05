package com.example.comp3111f23g05.controller;

import com.example.comp3111f23g05.Manager.SceneManager;
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
        SceneManager.getInstance().toEditor();
    }

    @FXML
    void mouseClickedShortestPath(MouseEvent event) {
        SceneManager.getInstance().toShortestPath();

    }

    @FXML
    void mouseClickedStartGame(MouseEvent event) {
        SceneManager.getInstance().toIndex();

    }

    @FXML
    void mouseEnteredMapCustomization(MouseEvent event) {
    }

    @FXML
    void mouseEnteredShortestPath(MouseEvent event) {
    }

    @FXML
    void mouseEnteredStartGame(MouseEvent event) {
    }

    @FXML
    void mouseExitedMapCustomization(MouseEvent event) {
    }

    @FXML
    void mouseExitedShortestPath(MouseEvent event) {
    }

    @FXML
    void mouseExitedStartGame(MouseEvent event) {
    }

}
