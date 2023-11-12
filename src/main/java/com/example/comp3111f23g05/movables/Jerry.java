package com.example.comp3111f23g05.movables;

import com.example.comp3111f23g05.map.Coordinate;

public class Jerry extends Movables {

    public static final long MINIMUM_MOVEMENT_INTERVAL = (long) (0.35 * Math.pow(10, 9));

    public Jerry(Coordinate position) {
        super(position, "/images/Jerry.gif");
    }
}
