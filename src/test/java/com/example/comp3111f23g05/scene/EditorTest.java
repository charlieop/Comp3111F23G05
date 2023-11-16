package com.example.comp3111f23g05.scene;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

class EditorTest extends ApplicationTest {
    public void start(Stage stage) {
        // Create a simple JavaFX application with a button
        Button button = new Button("Click me!");
        StackPane root = new StackPane(button);
        stage.setScene(new Scene(root, 100, 100));
        stage.show();
    }

    @Test
    public void testButtonClick() {
        // Find the button and click it
        clickOn("Click me!");
    }
}
// fest swing
// testFX