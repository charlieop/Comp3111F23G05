package com.example.comp3111f23g05.scene;

import com.example.comp3111f23g05.manager.AudioManager;
import com.example.comp3111f23g05.manager.SceneManager;
import com.example.comp3111f23g05.manager.Sound;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.framework.junit.TestFXRule;

import static org.junit.jupiter.api.Assertions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShortestPathSceneTest extends ApplicationTest {
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
        Platform.runLater(() -> {
            //valid fxml
            ShortestPath.init(stage, "/fxml/gameArea.fxml", "ShortestPathData.csv"); // target function
            //invalid fxml
            ShortestPath.init(stage, "", "ShortestPathData.csv"); // target function
        });
    }
    @Test
    public void GenerateCSVTest (){
        // target function:
        // corresponding button click part in init()
        // and private method: GeneratePathCSV()

        //valid
        SceneManager.getInstance().toShortestPath();
        clickOn("Generate CSV"); // target function
        sleep(1000);
        clickOn("OK"); // target function
        sleep(300);

        //invalid CSVName
        ShortestPath.init(stage, "/fxml/gameArea.fxml", "");
        clickOn("Generate CSV"); // target function
        sleep(1000);
        clickOn("OK"); // target function
        sleep(300);
    }


}