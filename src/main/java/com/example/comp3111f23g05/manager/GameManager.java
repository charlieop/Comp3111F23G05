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
    
    // return empty array if invalid or no path found
    public Coordinate[] CalculateShortestPath (Map map, Coordinate start, Coordinate end){
        //array to mark the min steps tp reach a position
        int[][] RecordMap = new int[Map.MAP_SIZE][Map.MAP_SIZE];
        for (int[] ints : RecordMap) Arrays.fill(ints, -1);
        return CalculateShortestPath(map, start, end, RecordMap, 0);
    }
    private Coordinate[] CalculateShortestPath (Map map, Coordinate start, Coordinate end, int[][] RecordMap, int step){
        Coordinate[] path = new Coordinate[0];
        Block[][] mapData = map.getMap();

        // explore this pos only when not visited or reached with smaller steps
        if(RecordMap[start.y][start.x] == -1 || step < RecordMap[start.y][start.x])
            RecordMap[start.y][start.x] = step;
        else
            return new Coordinate[0];

        //check if start and end are clear blocks
        if(!mapData[start.y][start.x].reachable() || !mapData[end.y][end.x].reachable()){
            return new Coordinate[0];
        }

        //reach end
        if (start.equals(end)) {
            path = new Coordinate[1];
            path[0] = new Coordinate(start.x, start.y);
            return path;
        }

        // find min subpath
        int minLen = 99999;
        for (Coordinate pos : start.surroundings()) {
            if (!Coordinate.checkX(pos.x) || !Coordinate.checkY(pos.y)) { //double check pos
                continue;
            }
            Block cur = mapData[pos.y][pos.x];
            if (!cur.reachable())
                continue;
            Coordinate[] p = CalculateShortestPath(map, new Coordinate(pos.x, pos.y), end, RecordMap, step+1);
            int l = p.length;
            if (l != 0 && l < minLen) { //update if find shorter valid path
                minLen = l;
                path = p;
            }
        }

        // no subpath reaches end
        if(path.length == 0){
            return new Coordinate[0];
        }

        // add start pos to subpath
        Coordinate[] subpath = path;
        path = new Coordinate[subpath.length+1];
        path[0] = new Coordinate(start.x, start.y);
        System.arraycopy(subpath, 0, path, 1, path.length-1);
        return path;
    }

}
