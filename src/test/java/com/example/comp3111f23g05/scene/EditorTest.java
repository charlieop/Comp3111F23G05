package com.example.comp3111f23g05.scene;

import com.example.comp3111f23g05.manager.SceneManager;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class EditorTest extends ApplicationTest {
    Stage stage;
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        SceneManager.getInstance().init(stage);
        SceneManager.getInstance().toEditor();
    }
    @Test
    public void initTest() {
        Platform.runLater(() -> {
            Editor.init(stage, "/fxml/gameArea.fxml"); // target function
            Editor.init(stage, ""); // target function
        });
    }
}