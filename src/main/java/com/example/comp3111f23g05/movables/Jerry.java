package com.example.comp3111f23g05.movables;

import com.example.comp3111f23g05.map.Coordinate;
import javafx.scene.input.KeyCode;

public class Jerry extends Movables {

    public static final int MINIMUM_MOVEMENT_INTERVAL = 1000;

    private UserInput input;
    public Jerry(Coordinate position){
        super(position, "/images/Jerry.gif");
    }

    public void pressed(KeyCode keyCode) {

    }

    public void released(KeyCode keyCode){

    }

    @Override
    public void move() {

    }
}
