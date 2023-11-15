package com.example.comp3111f23g05.scene;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortestPathSceneTest {
    public void initTest(){
        Stage stage = new Stage();
        ShortestPath.init(stage);
    }
    @Test
    public void GenerateCSVTestCase(){
        //how to test private function that only triggered by pressing button?
    }

}