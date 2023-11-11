package com.example.comp3111f23g05.movables;

import com.example.comp3111f23g05.map.Coordinate;

public class Tom extends Movables{
    public static final int MINIMUM_MOVEMENT_INTERVAL = 800;

    public Tom(Coordinate position){
        super(position, "/images/Tom.png");
    }

    @Override
    public void move() {

    }
}
