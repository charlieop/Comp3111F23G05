package com.example.comp3111f23g05.controller;

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

    }

    @FXML
    void mouseClickedShortestPath(MouseEvent event) {

    }

    @FXML
    void mouseClickedStartGame(MouseEvent event) {

    }

    @FXML
    void mouseEnteredMapCustomization(MouseEvent event) {
        mapCustomization.setOpacity(0.8);
    }

    @FXML
    void mouseEnteredShortestPath(MouseEvent event) {
        shortestPath.setOpacity(0.8);
    }

    @FXML
    void mouseEnteredStartGame(MouseEvent event) {
        startGame.setOpacity(0.8);
    }

    @FXML
    void mouseExitedMapCustomization(MouseEvent event) {
        mapCustomization.setOpacity(1);
    }

    @FXML
    void mouseExitedShortestPath(MouseEvent event) {
        shortestPath.setOpacity(1);
    }

    @FXML
    void mouseExitedStartGame(MouseEvent event) {
        startGame.setOpacity(1);
    }

}
