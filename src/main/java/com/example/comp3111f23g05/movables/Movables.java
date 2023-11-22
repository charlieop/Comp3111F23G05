package com.example.comp3111f23g05.movables;

import com.example.comp3111f23g05.manager.SceneManager;
import com.example.comp3111f23g05.map.Coordinate;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * The Movables class represents movable objects in the game.
 * It contains information about the position and image of the object.
 */
public class Movables{

    /**
     * The position of the movable object.
     */
    public Coordinate position;

    /**
     * The image of the movable object.
     */
    private final Image image;

    /**
     * The last time the object moved.
     */
    public long lastMovedTime = 0;

    /**
     * The minimum interval between movements of the object.
     */
    public long MINIMUM_MOVEMENT_INTERVAL;

    /**
     * Initializes the movable object with the specified position, image, and speed.
     *
     * @param position   The position of the movable object.
     * @param imageName  The name of the image file for the movable object.
     * @param speed      The speed of the movable object.
     */
    public Movables(Coordinate position, String imageName, long speed) {
        MINIMUM_MOVEMENT_INTERVAL = speed;
        this.position = position;
        this.image = new Image(getClass().getResourceAsStream(imageName));
    }

    /**
     * Paints the movable object on the graphics context.
     *
     * @param graphicsContext  The graphics context on which to paint the object.
     */
    public void paint(GraphicsContext graphicsContext) {
        final int size = SceneManager.BLOCK_SIZE;
        graphicsContext.drawImage(image, position.x * size, position.y * size, size, size);
    }
}
