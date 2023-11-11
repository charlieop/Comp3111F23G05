package com.example.comp3111f23g05.movables;

import com.example.comp3111f23g05.map.Coordinate;
import javafx.scene.input.KeyCode;

public class Jerry extends Movables {

    public static final long MINIMUM_MOVEMENT_INTERVAL = (long) (0.4 * Math.pow(10, 9));

    public Jerry(Coordinate position) {
        super(position, "/images/Jerry.gif");
    }

    public void pressed(KeyCode keyCode) {

    }

    public void released(KeyCode keyCode) {

    }
}
