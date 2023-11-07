package com.example.comp3111f23g05.manager;

import com.example.comp3111f23g05.map.Block;
import com.example.comp3111f23g05.map.Coordinate;
import com.example.comp3111f23g05.map.Map;

import java.util.Arrays;

public class GameManager {
    private static final GameManager instance = new GameManager();
    private GameManager() {}
    public static GameManager getInstance() {
        return instance;
    }
    
    // return enpty array if invalid or no path found
    public Coordinate[] CalculateShortestPath (Map map, Coordinate start, Coordinate end){
        //array to mark a place have been reached
        int[][] RecordMap = new int[Map.MAP_SIZE][Map.MAP_SIZE];
        for (int[] ints : RecordMap) Arrays.fill(ints, -1);
        return CalculateShortestPath(map, start, end, RecordMap, 0);
    }
    private Coordinate[] CalculateShortestPath (Map map, Coordinate start, Coordinate end, int[][] RecordMap, int step){
        Coordinate[] path = new Coordinate[0];
        Block[][] mapData = map.getMap();
        int startRow = start.getY();
        int startCol = start.getX();
        int endRow = end.getY();
        int endCol = end.getX();

        // if visited
        // 0 for un-visited
        // 1 for visited
        if(RecordMap[startRow][startCol] == -1 || step < RecordMap[startRow][startCol])
            RecordMap[startRow][startCol] = step;
        else
            return new Coordinate[0];

        //check if start and end are valid
        if(!mapData[startRow][startCol].reachable() || !mapData[endRow][endCol].reachable()){
            // System.out.println("invalid start and end");
            return new Coordinate[0];
        }

        //reach end
        if (start.equals(end)) {
            //System.out.println("reached the end");
            path = new Coordinate[1];
            path[0] = new Coordinate(startCol, startRow);
            return path;
        }

        // find min subpath
        int minLen = 1000000;
        int[] index = {-1,1};
        for (int j = 0; j < index.length; j++){
            int col = startCol + index[j];
            //System.out.println(row +" " + col);
            if ( !Coordinate.checkX(col) ){
                continue;
            }
            Block cur = mapData[startRow][col];
            if(!cur.reachable())
                continue;
            Coordinate[] p = CalculateShortestPath(map, new Coordinate(col, startRow), end, RecordMap, step+1);
            int l = p.length;
            if (l != 0 && l < minLen){
                minLen = l;
                path = p;
            }
        }

        for (int i = 0; i < index.length; i++){
            int row = startRow + index[i];
            //System.out.println(row +" " + col);
            if (!Coordinate.checkY(row)){
                continue;
            }
            Block cur = mapData[row][startCol];
            if(!cur.reachable())
                continue;
            Coordinate[] p = CalculateShortestPath(map, new Coordinate(startCol,row), end, RecordMap, step+1);
            int l = p.length;
            if (l != 0 && l < minLen){
                minLen = l;
                path = p;
            }
        }


        // no subpath reaches end
        if(path.length == 0){
            return new Coordinate[0];
        }

        Coordinate[] subpath = path;
        path = new Coordinate[subpath.length+1];
        path[0] = new Coordinate(startCol, startRow);
        System.arraycopy(subpath, 0, path, 1, path.length - 1);
        return path;
    }

}
