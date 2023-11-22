package com.example.comp3111f23g05.scene;

import com.example.comp3111f23g05.manager.SceneManager;
import javafx.stage.Stage;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.framework.junit.TestFXRule;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GameSceneTest extends ApplicationTest {
    Stage stage;
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        SceneManager.getInstance().init(stage);
    }

    @Rule
    public TestFXRule testFXRule = new TestFXRule();

    @Test
    public void InitTest(){
        Game.init(stage, "/fxml/gameArea.fxml");
        Game.init(stage, "");

    }

    @Test
    public void ReturnHomeTest(){
        SceneManager.getInstance().toGame();
        sleep(300);
        clickOn("Home");// target function
        sleep(300);
    }

}