package com.example.comp3111f23g05.map;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * The Map class represents the game map.
 * It contains information about the size of the map, map data, entry and exit positions, and methods to load and save the map.
 */
public class Map {

    /**
     * The size of the map.
     */
    public static final int MAP_SIZE = 30;

    /**
     * The map data, stored as a 2D array of blocks.
     */
    private final Block[][] mapData;

    /**
     * The position of the entry block.
     */
    public Coordinate entryPos;

    /**
     * The position of the exit block.
     */
    public Coordinate exitPos;

    /**
     * Initializes the map and loads the map data from a file.
     */
    public Map() {
        mapData = new Block[30][30];
        loadMap();
    }

    /**
     * Loads the map data from a file.
     */
    private void loadMap() {
        URL res = getClass().getClassLoader().getResource("MazeMap.csv");
        try {
            assert res != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(res.openStream()));
            String row;
            int rowNum = 0;
            while ((row = reader.readLine()) != null)  //Reads a line of text
            {
                String[] col = row.split(","); //utilized to split the string
                for (int colNum = 0; colNum < col.length; colNum++) {
                    setBlock(col[colNum], rowNum, colNum);
                }
                rowNum++;
            }
        } catch (IOException ignored) {
            System.out.println("There is an error in the loadMap");
            return;
        }
    }

    /**
     * Returns the map data.
     *
     * @return The map data.
     */
    public Block[][] getMap() {
        return mapData;
    }

    /**
     * Sets a block in the map based on the specified type, row, and column.
     *
     * @param type  The type of the block.
     * @param row  The row of the block in the map.
     * @param col  The column of the block in the map.
     */
    private void setBlock(String type, int row, int col) {
        Block newBlock;
        switch (type.strip()) {
            case "1":
                newBlock = new Block(BlockType.BARRIER);
                break;
            case "2":
                newBlock = new Block(BlockType.BOUNDARY);
                break;
            case "3":
                newBlock = new Block(BlockType.ENTRY);
                entryPos = new Coordinate(col, row);
                break;
            case "4":
                newBlock = new Block(BlockType.EXIT);
                exitPos = new Coordinate(col, row);
                break;
            default:
                newBlock = new Block(BlockType.CLEAR);
        }
        mapData[row][col] = newBlock;
    }

    /**
     * Saves the map data to a file.
     */
    public void saveMap() {
        URL res = getClass().getClassLoader().getResource("MazeMap.csv");
        String path = null;
        assert res != null;
        try {
            path = new File(res.toURI()).getAbsolutePath();
            String str = "";
            for (Block[] row : mapData) {
                for (Block block : row) {
                    str += block.getType().ordinal() + ",";
                }
                str += "\n";
                BufferedWriter writer = new BufferedWriter(new FileWriter(path));
                writer.write(str);
                writer.close();
            }
        } catch (URISyntaxException | IOException ignored) {
            System.out.println("There is an error in the saveMap");
            return;
        }
    }
}