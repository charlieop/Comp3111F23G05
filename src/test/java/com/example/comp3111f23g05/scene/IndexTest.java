package com.example.comp3111f23g05.scene;

import com.example.comp3111f23g05.manager.SceneManager;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class IndexTest extends ApplicationTest {
    Stage stage;
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        SceneManager.getInstance().init(stage);
    }

    @Test
    public void initTest() {

        Index.init(stage, "/fxml/index.fxml"); // target function
        Index.init(stage, ""); // target function
    }

}