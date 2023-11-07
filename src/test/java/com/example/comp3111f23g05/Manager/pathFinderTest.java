package com.example.comp3111f23g05.Manager;

import com.example.comp3111f23g05.Map.Coordinate;
import com.example.comp3111f23g05.Map.Map;
import org.junit.jupiter.api.Test;

class pathFinderTest {
    Map map = new Map();


    @Test
    void len2(){
        Coordinate[] path1 = GameManager.getInstance().CalculateShortestPath(map,new Coordinate(0,12), new Coordinate(1,12));

        System.out.println(path1.length);
        for(int i = 0; i < path1.length; i++){
            System.out.println(path1[i].getX() +" " + path1[i].getY());
        }


    }
    @Test
    void len7(){
        Coordinate[] path2 = GameManager.getInstance().CalculateShortestPath(map,new Coordinate(0,12), new Coordinate(4,14));
        System.out.println(path2.length);
        for(int i = 0; i < path2.length; i++){
            System.out.println(path2[i].getX() +" " + path2[i].getY());
        }
    }
    @Test
    void EntryToExit(){
        Coordinate[] path = GameManager.getInstance().CalculateShortestPath(map,new Coordinate(0,12), new Coordinate(29,1));
        System.out.println(path.length);
        for(int i = 0; i < path.length; i++){
            System.out.println(path[i].getX() +" " + path[i].getY());
        }
    }
}