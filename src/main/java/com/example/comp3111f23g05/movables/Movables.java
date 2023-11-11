package com.example.comp3111f23g05.movables;

import com.example.comp3111f23g05.manager.SceneManager;
import com.example.comp3111f23g05.map.Coordinate;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Movables{
    boolean alive = true;
    Coordinate position;
    Image image;

    public Movables(Coordinate position, String imageName) {
        this.position = position;
        this.image = new Image(getClass().getResourceAsStream(imageName));
    }

    public Coordinate getCoordinates(){
        return position;
    }

    public boolean isAlive(){
        return alive;
    }

    public void paint(GraphicsContext graphicsContext) {
        final int size = SceneManager.BLOCK_SIZE;
        graphicsContext.drawImage(image, position.x*size, position.y*size, size, size);
    }

    public abstract void move();
}
