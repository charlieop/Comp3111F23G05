package com.example.comp3111f23g05.Map;

import com.example.comp3111f23g05.Manager.SceneManager;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block extends StackPane {
    private Coordinate pos;
    private BlockType type;
    private Rectangle visual = new Rectangle(SceneManager.BLOCK_SIZE, SceneManager.BLOCK_SIZE);

    public Block(Coordinate pos, BlockType type) {
        this.pos = pos;
        this.type = type;
        if (type==BlockType.BARRIER) {
            visual.setFill(Color.DARKGRAY);
        }
        else {
            visual.setFill(Color.LIGHTGRAY);
        }
        getChildren().add(visual);
    }
}
