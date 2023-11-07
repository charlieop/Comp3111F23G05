package com.example.comp3111f23g05.map;

import com.example.comp3111f23g05.manager.SceneManager;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Block extends StackPane {
    private BlockType type;
    private final Rectangle base = new Rectangle(SceneManager.BLOCK_SIZE, SceneManager.BLOCK_SIZE);

    public Block(BlockType type) {
        this.type = type;
        changeVisual();
    }

    public BlockType getType() {
        return type;
    }

    public void setType(BlockType type) {
        this.type = type;
        changeVisual();
    }
    private void changeVisual() {
        getChildren().removeAll();
        getChildren().add(base);
        switch (type) {
            case BARRIER:
                base.setFill(Color.DARKGRAY);
                getChildren().add(new Text("X"));
                break;
            case CLEAR:
                base.setFill(Color.TRANSPARENT);
                break;
            case ENTRY:
                base.setFill(Color.WHITE);
                break;
            case EXIT:
                base.setFill(Color.GREEN);
                break;
            case BOUNDARY:
                base.setFill(Color.BLACK);
                break;
            case HIGHLIGHTED:
                base.setFill(Color.LIGHTGREEN);
                break;
        }
    }
}
