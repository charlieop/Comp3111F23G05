package com.example.comp3111f23g05.manager;

import javafx.scene.input.KeyCode;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class GameManagerRefreshTest extends ApplicationTest {
    @Override
    public void start(javafx.stage.Stage stage) {
        SceneManager.getInstance().init(stage);
    }

    @Test
    public void HandelInputTest() {
        SceneManager.getInstance().toGame();
        sleep(1000);
        press(KeyCode.D);
        sleep(100);
        release(KeyCode.D);
        sleep(500);

        press(KeyCode.D);
        sleep(100);
        release(KeyCode.D);
        sleep(500);

        press(KeyCode.D);
        sleep(100);
        release(KeyCode.D);
        sleep(500);

        press(KeyCode.W);
        sleep(100);
        release(KeyCode.W);
        sleep(500);

        press(KeyCode.W);
        sleep(100);
        release(KeyCode.W);
        sleep(500);

        press(KeyCode.S);
        sleep(100);
        release(KeyCode.S);
        sleep(500);

        press(KeyCode.D);
        sleep(100);
        release(KeyCode.D);
        sleep(500);

        press(KeyCode.D);
        sleep(100);
        release(KeyCode.D);
        sleep(500);

        press(KeyCode.D);
        sleep(100);
        release(KeyCode.D);
        sleep(500);

        press(KeyCode.D);
        sleep(100);
        release(KeyCode.D);
        sleep(500);

        press(KeyCode.S);
        sleep(100);
        release(KeyCode.S);
        sleep(500);

        press(KeyCode.W);
        sleep(100);
        release(KeyCode.W);
        sleep(500);

        press(KeyCode.A);
        sleep(100);
        release(KeyCode.A);
        sleep(500);


        sleep(30000);
    }
}
