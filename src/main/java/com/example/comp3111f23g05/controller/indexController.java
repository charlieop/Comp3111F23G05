package com.example.comp3111f23g05.controller;

import com.example.comp3111f23g05.manager.AudioManager;
import com.example.comp3111f23g05.manager.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class indexController {

    @FXML
    private Button mapCustomization;

    @FXML
    private Button shortestPath;

    @FXML
    private Button startGame;

    @FXML
    void mouseClickedMapCustomization(MouseEvent event) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        AudioManager.getInstance().play("/sounds/done.wav");
        SceneManager.getInstance().toEditor();
    }

    @FXML
    void mouseClickedShortestPath(MouseEvent event) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        AudioManager.getInstance().play("/sounds/done.wav");
        SceneManager.getInstance().toShortestPath();

    }

    @FXML
    void mouseClickedStartGame(MouseEvent event) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        AudioManager.getInstance().play("/sounds/done.wav");
        SceneManager.getInstance().toGame();

    }

    @FXML
    void mouseEnteredMapCustomization(MouseEvent event) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        AudioManager.getInstance().play("/sounds/button.wav");
    }

    @FXML
    void mouseEnteredShortestPath(MouseEvent event) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        AudioManager.getInstance().play("/sounds/button.wav");
    }

    @FXML
    void mouseEnteredStartGame(MouseEvent event) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        AudioManager.getInstance().play("/sounds/button.wav");
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
