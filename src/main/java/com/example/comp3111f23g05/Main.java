package com.example.comp3111f23g05;

import com.example.comp3111f23g05.manager.AudioManager;
import com.example.comp3111f23g05.manager.SceneManager;
import com.example.comp3111f23g05.manager.Sound;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
public class Main extends Application {
    @Override
    public void init() throws Exception {
        super.init();
    }
    @Override
    public void start(Stage stage) throws IOException {
        AudioManager.getInstance().play(Sound.THEME,true);
        SceneManager.getInstance().init(stage);
    }
    @Override
    public void stop() throws Exception {
        super.stop();
    }
    public static void main(String[] args) {
        launch(args);
    }
}