package com.example.comp3111f23g05.movables;

import com.example.comp3111f23g05.map.Coordinate;

public class Tom extends Movables{
    public static final long MINIMUM_MOVEMENT_INTERVAL = (long) (0.4 * Math.pow(10, 9));

    public Tom(Coordinate position){
        super(position, "/images/Tom.png");
    }

}
