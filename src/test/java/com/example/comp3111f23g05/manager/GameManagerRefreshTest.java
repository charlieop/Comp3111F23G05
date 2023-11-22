package com.example.comp3111f23g05.manager;

import javafx.scene.input.KeyCode;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class GameManagerRefreshTest extends ApplicationTest {

    //Specification
    // There are two methods that are responsible to handle the users' keycode input
    // The first one is a private function in gameManager class which is named "keycodeProcess()".
    // And it will only be called by the following handle() function.
    // The second one is a public function in Refresh class, which is named handle() function.
    // This design is to encode the users' input keycode more convenient
    // And the keycodeProcess() function is only called by this handle() function.
    // The handle() function does not call other function except this keycodeProcess() function
    // Since they are closely related and responsible for the same functionality, we test they as a whole

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
        sleep(500); // target function

        press(KeyCode.W);
        sleep(100);
        release(KeyCode.W);
        sleep(500); // target function

        press(KeyCode.S);
        sleep(100);
        release(KeyCode.S);
        sleep(500); // target function

        press(KeyCode.A);
        sleep(100);
        release(KeyCode.A);
        sleep(500); // target function

        press(KeyCode.A);
        sleep(100);
        release(KeyCode.A);
        sleep(500);

        press(KeyCode.A);
        sleep(100);
        release(KeyCode.A);
        sleep(500);

        press(KeyCode.A);
        sleep(100);
        release(KeyCode.A);
        sleep(500);

        press(KeyCode.D);
        sleep(100);
        release(KeyCode.D);
        sleep(500);

        sleep(30000);
    }
}
