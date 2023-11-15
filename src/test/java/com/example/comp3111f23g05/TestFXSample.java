package com.example.comp3111f23g05;

import com.example.comp3111f23g05.manager.SceneManager;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class TestFXSample extends ApplicationTest {

    @Override
    public void start(Stage stage) {
        // Create a simple JavaFX application with a button
        SceneManager.getInstance().init(stage);
    }

    @Test
    public void testButtonClick() {
        // Find the button and click it
        clickOn("Edit Map");
        clickOn("OK");

        // start drag
        drag(MouseButton.PRIMARY);

        // move mouse button
        moveBy(-100, -300);

        // release drag
        release(MouseButton.PRIMARY);

        moveTo(600, 600);

        // wait for you to see
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
// if you see an error message, do this:
// run - edit config - JUnit - add vm options - input the below codes and click apply:
//    --add-exports javafx.graphics/com.sun.javafx.application=ALL-UNNAMED
//    --add-opens javafx.base/com.sun.javafx.runtime=ALL-UNNAMED
//    --add-opens javafx.controls/com.sun.javafx.scene.control.behavior=ALL-UNNAMED
//    --add-opens javafx.controls/com.sun.javafx.scene.control=ALL-UNNAMED
//    --add-opens javafx.base/com.sun.javafx.binding=ALL-UNNAMED
//    --add-opens javafx.base/com.sun.javafx.event=ALL-UNNAMED
//    --add-opens javafx.graphics/com.sun.javafx.stage=ALL-UNNAMED
//    --add-opens javafx.graphics/com.sun.javafx.application=ALL-UNNAMED