package com.example.comp3111f23g05.scene;

import com.example.comp3111f23g05.manager.SceneManager;
import javafx.stage.Stage;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.framework.junit.TestFXRule;

import static org.junit.jupiter.api.Assertions.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GameOverSceneTest extends ApplicationTest {
    Stage stage;
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        SceneManager.getInstance().init(stage);
    }

    @Rule
    public TestFXRule testFXRule = new TestFXRule();

    @Test
    public void initTest() {
        // valid fxml
        GameOver.init(stage,"/fxml/gameArea.fxml", true); // target function

        GameOver.init(stage, "/fxml/gameArea.fxml",false); // target function

        // invalid fxml
        GameOver.init(stage, "",false); // target function
    }

}