package com.example.comp3111f23g05.Map;

import com.example.comp3111f23g05.Manager.SceneManager;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block extends StackPane {
    private BlockType type;
    private Rectangle visual = new Rectangle(SceneManager.BLOCK_SIZE, SceneManager.BLOCK_SIZE);

    public Block(BlockType type) {
        this.type = type;
        changeVisual();
        getChildren().add(visual);
    }

    public BlockType getType() {
        return type;
    }

    public void setType(BlockType type) {
        this.type = type;
        changeVisual();
    }
    private void changeVisual() {
        switch (type) {
            case BARRIER:
                visual.setFill(Color.DARKGRAY);
                break;
            case CLEAR:
                visual.setFill(Color.LIGHTGRAY);
                break;
            case ENTRY:
                visual.setFill(Color.WHITE);
                break;
            case EXIT:
                visual.setFill(Color.GREEN);
                break;
            case BOUNDARY:
                visual.setFill(Color.BLACK);
                break;
            case HIGHLIGHTED:
                visual.setFill(Color.LIGHTGREEN);
                break;
        }
    }

    public boolean reachable(){
        return this.type.canArrive();
    }
}
