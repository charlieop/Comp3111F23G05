package com.example.comp3111f23g05.map;

import com.example.comp3111f23g05.manager.SceneManager;
import com.example.comp3111f23g05.scene.Game;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

/**
 * The Block class represents a block in the game map.
 * It contains information about the type and visual representation of the block.
 */
public class Block extends StackPane {

    /**
     * The type of the block.
     */
    private BlockType type;

    /**
     * The base rectangle of the block.
     */
    private final Rectangle base = new Rectangle(SceneManager.BLOCK_SIZE, SceneManager.BLOCK_SIZE);

    /**
     * Initializes the block with the specified type.
     *
     * @param type  The type of the block.
     */
    public Block(BlockType type) {
        this.type = type;
        changeVisual();
    }

    /**
     * Returns the type of the block.
     *
     * @return The type of the block.
     */
    public BlockType getType() {
        return type;
    }

    /**
     * Sets the type of the block.
     *
     * @param type  The type of the block.
     */
    public void setType(BlockType type) {
        this.type = type;
        changeVisual();
    }

    /**
     * Changes the visual representation of the block based on its type.
     */
    private void changeVisual() {
        getChildren().clear();
        getChildren().add(base);
        ImageView imageView = new ImageView();
        Image img;
        imageView.setFitHeight(SceneManager.BLOCK_SIZE);
        imageView.setFitWidth(SceneManager.BLOCK_SIZE);
        Random random = new Random();
        switch (type) {
            case BARRIER:
                int i = random.nextInt(90);
                String name = i < 6 ? "-" + i : "";
                img = new Image(String.valueOf(Game.class.getResource("/images/barriers/barrier" + name + ".png")));
                imageView.setImage(img);
                getChildren().add(imageView);
                base.setFill(Color.TRANSPARENT);
                break;
            case CLEAR:
                base.setFill(Color.TRANSPARENT);
                break;
            case ENTRY:
                img = new Image(String.valueOf(Game.class.getResource("/images/entry.jpg")));
                imageView.setImage(img);
                getChildren().add(imageView);
                break;
            case EXIT:
                img = new Image(String.valueOf(Game.class.getResource("/images/exit.png")));
                imageView.setImage(img);
                getChildren().add(imageView);
                base.setFill(Color.GREEN);
                break;
            case BOUNDARY:
                base.setFill(Color.BLACK);
                break;
            case HIGHLIGHTED:
                img = new Image(String.valueOf(Game.class.getResource("/images/path.png")));
                imageView.setImage(img);
                getChildren().add(imageView);
                break;
        }
    }

    /**
     * Checks if the block is reachable.
     *
     * @return True if the block is reachable, false otherwise.
     */
    public boolean reachable(){
        return !(type == BlockType.BARRIER || type == BlockType.BOUNDARY);
    }
}