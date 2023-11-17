package com.example.comp3111f23g05.scene;

import com.example.comp3111f23g05.manager.SceneManager;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.framework.junit.TestFXRule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EditorTest extends ApplicationTest {
    Stage stage;
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        SceneManager.getInstance().init(stage);
        SceneManager.getInstance().toEditor();
    }

    @Rule
    public TestFXRule testFXRule = new TestFXRule();

    @Test
    public void A_initTest() {
        Platform.runLater(() -> {
            Editor.init(stage, "/fxml/gameArea.fxml"); // target function
            Editor.init(stage, ""); // target function
        });
    }

//    @Test
//    public void clearMapTest() {
//        Platform.runLater(() -> {
//            clickOn("ClearMap"); // target function
//        });
//    }

    @Test
    public void clearMapAlertTest() {
        clickOn("ClearMap");
        sleep(300);
        clickOn("Cancel"); // target function
        sleep(300);
        clickOn("ClearMap");
        sleep(300);
        clickOn("Yes"); // target function
    }

//    @Test
//    public void returnHomeTest() {
//        clickOn("Home"); // target function
//    }

    @Test
    public void returnHomeAlertTest() {
        clickOn("Home");
        sleep(300);
        clickOn("Close"); // target function
        sleep(300);
        clickOn("Home");
        sleep(300);
        clickOn("No"); // target function
        sleep(300);
        SceneManager.getInstance().toEditor();
        clickOn("Home");
        sleep(300);
        clickOn("Yes"); // target function
        sleep(300);
        SceneManager.getInstance().toEditor();
        Point2D pos = new Point2D(stage.getX()+175, stage.getY()+50);
        moveTo(pos);
        press(MouseButton.PRIMARY);
        sleep(300);
        release(MouseButton.PRIMARY);
        sleep(1000);
        clickOn("Home");
        sleep(300);
        clickOn("Yes"); // target function
        sleep(300);
        clickOn("OK");
        sleep(300);
    }

    @Test
    public void mouseClickTest() {
        Point2D pos = new Point2D(stage.getX()+175, stage.getY()+50);
        moveTo(pos);

        press(MouseButton.PRIMARY); // target function
        sleep(300);
        release(MouseButton.PRIMARY);

        sleep(500);

        press(MouseButton.PRIMARY); // target function
        sleep(300);
        release(MouseButton.PRIMARY);

        sleep(300);

        drag(MouseButton.PRIMARY);
        moveBy(100, 0);
        release(MouseButton.PRIMARY);

        press(MouseButton.PRIMARY); // target function
        sleep(300);
        release(MouseButton.PRIMARY);
    }

    @Test
    public void mouseDragTest() {

        Point2D pos = new Point2D(stage.getX()+180, stage.getY()+50);
        moveTo(pos);

        drag(MouseButton.PRIMARY);
        moveBy(300, 0); // target function
        release(MouseButton.PRIMARY);

        sleep(300);

        pos = new Point2D(stage.getX()+160, stage.getY()+50);
        moveTo(pos);

        sleep(300);

        drag(MouseButton.PRIMARY);
        moveBy(0, 160); // target function
        moveBy(400, -200); // target function
        release(MouseButton.PRIMARY);

        sleep(300);

        pos = new Point2D(stage.getX()+740, stage.getY()+550);
        moveTo(pos);

        sleep(300);

        drag(MouseButton.PRIMARY);
        moveBy(0, -300); // target function
        release(MouseButton.PRIMARY);

        sleep(300);
    }

}