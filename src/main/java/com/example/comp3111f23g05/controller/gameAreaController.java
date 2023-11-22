package com.example.comp3111f23g05.controller;

import com.example.comp3111f23g05.manager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class gameAreaController {

    /**
     * The ImageView representing the background image of the game area.
     */
    @FXML
    private ImageView background;

    /**
     * Returns the background ImageView.
     *
     * @return The background ImageView.
     */
    public ImageView getBackground() {
        return background;
    }

    /**
     * The Button representing the functional button in the game area.
     */
    @FXML
    private Button functionalButton;

    /**
     * Returns the functional button.
     *
     * @return The functional button.
     */
    public Button getFunctionalButton() {
        return functionalButton;
    }

    /**
     * The StackPane representing the map area in the game area.
     */
    @FXML
    private StackPane mapArea;

    /**
     * Returns the map area StackPane.
     *
     * @return The map area StackPane.
     */
    public StackPane getMapArea() {
        return mapArea;
    }

    /**
     * The Button representing the return home button in the game area.
     */
    @FXML
    private Button returnHomeButton;

    /**
     * Returns the return home button.
     *
     * @return The return home button.
     */
    public Button getReturnHomeButton() {
        return returnHomeButton;
    }

    /**
     * Event handler for the return home button pressed event.
     *
     * @param event The ActionEvent object representing the button press event.
     */
    @FXML
    void returnHomeButtonPressed(ActionEvent event) {
        SceneManager.getInstance().toIndex();
    }
}