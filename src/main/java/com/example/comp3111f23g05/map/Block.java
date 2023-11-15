package com.example.comp3111f23g05.map;

import com.example.comp3111f23g05.manager.SceneManager;
import com.example.comp3111f23g05.scene.Game;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Random;

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
        getChildren().clear();
        getChildren().add(base);
        ImageView imageView = new ImageView();
        Image img;
        imageView.setFitHeight(SceneManager.BLOCK_SIZE);
        imageView.setFitWidth(SceneManager.BLOCK_SIZE);
        Random random = new Random();
        switch (type) {
            case BARRIER:
                if (random.nextInt(100) < 7) {
                    img = new Image(String.valueOf(Game.class.getResource("/images/barriers/barrier-" + random.nextInt(6) + ".png")));
                    imageView.setImage(img);
                    getChildren().add(imageView);
                    base.setFill(Color.TRANSPARENT);
                }
                else {
                    base.setFill(Color.GRAY);
                    getChildren().add(new Text("X"));
                }
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
                getChildren().add(new Text("O"));
                break;
        }
    }

    public boolean reachable(){
        return !(type == BlockType.BARRIER || type == BlockType.BOUNDARY);
    }
}
