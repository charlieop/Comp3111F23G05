package com.example.comp3111f23g05.manager;

import com.example.comp3111f23g05.map.Coordinate;
import com.example.comp3111f23g05.map.Map;
import org.junit.jupiter.api.Test;

class pathFinderTest {
    Map map = new Map();


    @Test
    void len2(){
        Coordinate[] path1 = GameManager.getInstance().CalculateShortestPath(map,new Coordinate(0,12), new Coordinate(1,12));

        System.out.println(path1.length);
        for(int i = 0; i < path1.length; i++){
            System.out.println(path1[i].x +" " + path1[i].y);
        }


    }
    @Test
    void len7(){
        Coordinate[] path2 = GameManager.getInstance().CalculateShortestPath(map,new Coordinate(0,12), new Coordinate(4,14));
        System.out.println(path2.length);
        for(int i = 0; i < path2.length; i++){
            System.out.println(path2[i].x +" " + path2[i].y);
        }
    }
    @Test
    void EntryToExit(){
        Coordinate[] path = GameManager.getInstance().CalculateShortestPath(map,new Coordinate(0,12), new Coordinate(29,1));
        System.out.println(path.length);
        for(int i = 0; i < path.length; i++){
            System.out.println(path[i].x +" " + path[i].y);
        }
    }
}