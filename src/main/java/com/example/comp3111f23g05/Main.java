package com.example.comp3111f23g05;

import com.example.comp3111f23g05.manager.AudioManager;
import com.example.comp3111f23g05.manager.SceneManager;
import com.example.comp3111f23g05.manager.Sound;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
public class Main extends Application {

    /**
     * The start method is called when the JavaFX application is launched.
     * It initializes the audio manager and scene manager, and starts playing the theme sound.
     *
     * @param stage The primary stage of the JavaFX application.
     * @throws IOException If there is an error initializing the scene manager.
     */
    @Override
    public void start(Stage stage) throws IOException {
        AudioManager.getInstance().play(Sound.THEME, true);
        SceneManager.getInstance().init(stage);
    }

    /**
     * The main method is the entry point for the Java application.
     * It launches the JavaFX application.
     *
     * @param args The command line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}