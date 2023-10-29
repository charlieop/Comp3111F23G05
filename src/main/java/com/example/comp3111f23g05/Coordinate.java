package com.example.comp3111f23g05;

public class Coordinate {
    static final int MAX_X = Map.MAP_SIZE;
    static final int MIN_X = 0;
    static final int MAX_Y = MAX_X;
    static final int MIN_Y = MIN_X;

    private int x;
    private int y;
    Coordinate() {
        x = MIN_X;
        y = MIN_Y;
    }
    Coordinate(int x, int y){
        if (!checkX(x) || !checkY(y)) {
            throw new RuntimeException("The value you created is now allowed!");
        }
        this.x = x;
        this.y = y;
    }

    public static boolean checkX(int x) {
        return ( x >= MIN_X && x <= MAX_X  );
    }
    public static boolean checkY(int y) {
        return ( y >= MIN_Y && y <= MAX_Y  );
    }

    public void setX(int x) {
        if (!checkX(x)) {
            throw new RuntimeException("The value x is invalid!");
        }
        this.x = x;
    }
    public void setY(int y) {
        if (!checkX(y)) {
            throw new RuntimeException("The value y is invalid!");
        }
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public boolean equals(Coordinate other) {
        return this.x == other.x && this.y == other.y;
    }

    public int calDistWith(Coordinate other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    }

}
