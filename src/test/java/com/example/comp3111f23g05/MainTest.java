package com.example.comp3111f23g05;

import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

public class MainTest extends ApplicationTest {

    Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
    }

    @Test
    public void testMain() {
        try {
            Main.main(new String[0]);
        }
        catch (Exception ignored) {
        }
    }

    @Test
    public void testStart() {
        Platform.runLater(() -> {
            Main main = new Main();
            try {
                main.start(stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });}
}