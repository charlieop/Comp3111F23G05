package com.example.comp3111f23g05.map;

public class Coordinate {
    static final int MAX_X = Map.MAP_SIZE - 1;
    static final int MIN_X = 0;
    static final int MAX_Y = MAX_X;
    static final int MIN_Y = MIN_X;
    public static boolean checkX(int x) {
        return ( x >= MIN_X && x <= MAX_X  );
    }
    public static boolean checkY(int y) {
        return ( y >= MIN_Y && y <= MAX_Y  );
    }
    public final int x;
    public final int y;
    public Coordinate(int x, int y){
        if (!checkX(x) || !checkY(y)) {
            throw new RuntimeException("The value you created is now allowed!");
        }
        this.x = x;
        this.y = y;
    }
    public boolean equals(Coordinate other) {
        return this.x == other.x && this.y == other.y;
    }
    public int calDistWith(Coordinate other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    }
}
