package com.example.comp3111f23g05.map;

/**
 * The Coordinate class represents a coordinate in the game map.
 * It contains information about the x and y positions of the coordinate.
 */
public class Coordinate {

    /**
     * The maximum value of the x position.
     */
    static final int MAX_X = Map.MAP_SIZE - 1;

    /**
     * The minimum value of the x position.
     */
    static final int MIN_X = 0;

    /**
     * The maximum value of the y position.
     */
    static final int MAX_Y = MAX_X;

    /**
     * The minimum value of the y position.
     */
    static final int MIN_Y = MIN_X;

    /**
     * Checks if the specified x position is valid.
     *
     * @param x  The x position to check.
     * @return True if the x position is valid, false otherwise.
     */
    public static boolean checkX(int x) {
        return ( x >= MIN_X && x <= MAX_X  );
    }

    /**
     * Checks if the specified y position is valid.
     *
     * @param y  The y position to check.
     * @return True if the y position is valid, false otherwise.
     */
    public static boolean checkY(int y) {
        return ( y >= MIN_Y && y <= MAX_Y  );
    }

    /**
     * The x position of the coordinate.
     */
    public final int x;

    /**
     * The y position of the coordinate.
     */
    public final int y;

    /**
     * Initializes the coordinate with the specified x and y positions.
     *
     * @param x  The x position of the coordinate.
     * @param y  The y position of the coordinate.
     * @throws RuntimeException if the x or y position is not valid.
     */
    public Coordinate(int x, int y){
        if (!checkX(x) || !checkY(y)) {
            throw new RuntimeException("The value you created is now allowed!");
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Checks if the coordinate is equal to the specified other coordinate.
     *
     * @param other  The other coordinate to compare.
     * @return True if the coordinates are equal, false otherwise.
     */
    public boolean equals(Coordinate other) {
        return this.x == other.x && this.y == other.y;
    }

    /**
     * Returns the surrounding coordinates of the current coordinate.
     *
     * @return An array of the surrounding coordinates.
     */
    public Coordinate[] surroundings() {
        Coordinate[] neighbors = new Coordinate[4];
        int numOfNeighbors = 0;
        int[] index = {-1, 1};
        for (int i: index) {
            if (checkX(x+i)){
                neighbors[numOfNeighbors] = new Coordinate(x+i, y);
                numOfNeighbors++;
            }
            if (checkY(y+i)){
                neighbors[numOfNeighbors] = new Coordinate(x, y+i);
                numOfNeighbors++;
            }
        }
        Coordinate[] surround = new Coordinate[numOfNeighbors];
        System.arraycopy(neighbors, 0, surround, 0, numOfNeighbors);
        return surround;
    }
}