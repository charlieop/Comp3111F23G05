package com.example.comp3111f23g05.scene;

import com.example.comp3111f23g05.manager.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

class EditorTest extends Application {
    public void testInit(Stage stage) {
        Editor.init(stage);
    }

    @Override
    public void start(Stage stage) throws Exception {
        SceneManager.getInstance().toIndex();
    }

    public static void main(String[] args) {
        launch(args);
    }
}