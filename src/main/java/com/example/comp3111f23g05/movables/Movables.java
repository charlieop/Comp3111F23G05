package com.example.comp3111f23g05.movables;

import com.example.comp3111f23g05.manager.SceneManager;
import com.example.comp3111f23g05.map.Coordinate;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Movables{
    public Coordinate position;
    private final Image image;
    public long lastMovedTime = 0;
    public long MINIMUM_MOVEMENT_INTERVAL;

    public Movables(Coordinate position, String imageName, long speed) {
        MINIMUM_MOVEMENT_INTERVAL = speed;
        this.position = position;
        this.image = new Image(getClass().getResourceAsStream(imageName));
    }

    public void paint(GraphicsContext graphicsContext) {
        final int size = SceneManager.BLOCK_SIZE;
        graphicsContext.drawImage(image, position.x * size, position.y * size, size, size);
    }
}
