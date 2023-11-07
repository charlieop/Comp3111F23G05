package com.example.comp3111f23g05.controller;

import com.example.comp3111f23g05.manager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class gameAreaController {

    @FXML
    private Button functionalButton;
    public Button getFunctionalButton() {
        return functionalButton;
    }

    @FXML
    private Text infoText;
    public Text getInfoText() {
        return infoText;
    }

    @FXML
    private StackPane mapArea;
    public StackPane getMapArea() {
        return mapArea;
    }

    @FXML
    private Button returnHomeButton;

    @FXML
    void functionalButtonPressed(ActionEvent event) {

    }

    @FXML
    void returnHomeButtonPressed(ActionEvent event) {
        SceneManager.getInstance().toIndex();
    }
}
