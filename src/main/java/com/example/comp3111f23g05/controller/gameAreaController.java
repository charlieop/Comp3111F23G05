package com.example.comp3111f23g05.controller;

import com.example.comp3111f23g05.manager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class gameAreaController {

    @FXML
    private ImageView background;
    public ImageView getBackground() {
        return background;
    }

    @FXML
    private Button functionalButton;
    public Button getFunctionalButton() {
        return functionalButton;
    }

    @FXML
    private StackPane mapArea;
    public StackPane getMapArea() {
        return mapArea;
    }

    @FXML
    private Button returnHomeButton;
    public Button getReturnHomeButton() {
        return returnHomeButton;
    }

    @FXML
    void returnHomeButtonPressed(ActionEvent event) {
        SceneManager.getInstance().toIndex();
    }
}
