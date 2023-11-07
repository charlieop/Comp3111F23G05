package com.example.comp3111f23g05.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Map {
    public static final int MAP_SIZE = 30;
    private final Block[][] mapData;
    public Map() {
        mapData = new Block[30][30];
        loadMap("MazeMap.csv");
    }
    public boolean loadMap(String fileName) {
        URL res = getClass().getClassLoader().getResource(fileName);
        if (res == null) {
            System.out.println("can not find file named: " + fileName);
            return false;
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(res.openStream()));
            String row;
            int rowNum = 0;
            while ((row = reader.readLine()) != null)  //Reads a line of text
            {
                String[] col = row.split(",");//utilized to split the string
                for (int colNum=0; colNum<col.length; colNum++) {
                    setBlock(col[colNum], rowNum, colNum);
                }
                rowNum++;
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Block[][] getMap() {
        return mapData;
    }
    private void setBlock(String type, int row, int col){
        Block newBlock;
        if (type.strip().equals("1")) {
            newBlock = new Block(BlockType.BARRIER);
        }
        else {
            newBlock = new Block(BlockType.CLEAR);
        }
        mapData[row][col] = newBlock;
    }

}

