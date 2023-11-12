package com.example.comp3111f23g05.manager;

import com.example.comp3111f23g05.map.Block;
import com.example.comp3111f23g05.map.Coordinate;
import com.example.comp3111f23g05.map.Map;
import com.example.comp3111f23g05.movables.Jerry;
import com.example.comp3111f23g05.movables.Tom;
import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;

import java.util.Arrays;

public class GameManager {
    private static final GameManager instance = new GameManager();

    private GameManager() {
    }

    public static GameManager getInstance() {
        return instance;
    }

    private Canvas canvas;

    public Canvas getCanvas() {
        return canvas;
    }
    private Tom tom;
    private Jerry jerry;

    private GraphicsContext graphicsContext;
    private Map map;
    public final Refresh refresh = new Refresh();
    KeyCode lastInput = null;

    private long currentTime;

    public void init(Parent root, Map map) {
        this.map = map;
        Coordinate tomPos = new Coordinate(map.exitPos.x, map.exitPos.y);
        Coordinate jerryPos = new Coordinate(map.entryPos.x, map.entryPos.y);
        tom = new Tom(tomPos);
        jerry = new Jerry(jerryPos);
        canvas = new Canvas();
        canvas.setWidth(Map.MAP_SIZE * SceneManager.BLOCK_SIZE);
        canvas.setHeight(Map.MAP_SIZE * SceneManager.BLOCK_SIZE);
        graphicsContext = canvas.getGraphicsContext2D();
        root.setOnKeyPressed(event -> {
            lastInput = event.getCode();
        });
        refresh.start();
    }

    private Coordinate keyCodeProcess(KeyCode keycode){
        int[] nextPosition = new int[]{0, 0};
        int x = jerry.position.x;
        int y =jerry.position.y;
        switch (keycode) {
            case W -> nextPosition[1] = -1;
            case S -> nextPosition[1] = 1;
            case A -> nextPosition[0] = -1;
            case D -> nextPosition[0] = 1;
        }
        if (!Coordinate.checkX(x + nextPosition[0]) || !Coordinate.checkY(y+nextPosition[1])) {
            nextPosition = new int[]{0, 0};
        }
        return new Coordinate(x + nextPosition[0], y+nextPosition[1]);
    }

    public class Refresh extends AnimationTimer {
        @Override
        public void handle(long now) {
            currentTime = now;
            graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            jerry.paint(graphicsContext);
            tom.paint(graphicsContext);
            if (jerry.position.equals(tom.position) || jerry.position.equals(map.exitPos)) {
                refresh.stop();
                AudioManager.getInstance().stop(Sound.GAME);
                SceneManager.getInstance().toGameOver(jerry.position.equals(map.exitPos));
            }
            if (currentTime - tom.lastMovedTime > Tom.MINIMUM_MOVEMENT_INTERVAL) {
                tom.lastMovedTime = currentTime;
                Coordinate nextPosition = CalculateShortestPath(map, tom.getCoordinates(), jerry.getCoordinates())[1];
                tom.move(nextPosition);
            }
            if (currentTime - jerry.lastMovedTime < Jerry.MINIMUM_MOVEMENT_INTERVAL || lastInput==null) {
                return;
            }
            Coordinate nextPosition = keyCodeProcess(lastInput);
            if (map.getMap()[nextPosition.y][nextPosition.x].reachable()) {
                jerry.lastMovedTime = currentTime;
                AudioManager.getInstance().play(Sound.JERRY, false);
                jerry.move(nextPosition);
                lastInput = null;
            }

        }
    }

// return empty array if invalid or no path found
    public Coordinate[] CalculateShortestPath(Map map, Coordinate start, Coordinate end) {
        //array to mark the min steps tp reach a position
        int[][] RecordMap = new int[Map.MAP_SIZE][Map.MAP_SIZE];
        for (int[] ints : RecordMap) Arrays.fill(ints, -1);
        return CalculateShortestPath(map, start, end, RecordMap, 0);
    }

    private Coordinate[] CalculateShortestPath(Map map, Coordinate start, Coordinate end, int[][] RecordMap, int step) {
        Coordinate[] path = new Coordinate[0];
        Block[][] mapData = map.getMap();

        // explore this pos only when not visited or reached with smaller steps
        if (RecordMap[start.y][start.x] == -1 || step < RecordMap[start.y][start.x])
            RecordMap[start.y][start.x] = step;
        else
            return new Coordinate[0];

        //check if start and end are clear blocks
        if (!mapData[start.y][start.x].reachable() || !mapData[end.y][end.x].reachable()) {
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
            Coordinate[] p = CalculateShortestPath(map, new Coordinate(pos.x, pos.y), end, RecordMap, step + 1);
            int l = p.length;
            if (l != 0 && l < minLen) { //update if find shorter valid path
                minLen = l;
                path = p;
            }
        }

        // no subpath reaches end
        if (path.length == 0) {
            return new Coordinate[0];
        }

        // add start pos to subpath
        Coordinate[] subpath = path;
        path = new Coordinate[subpath.length + 1];
        path[0] = new Coordinate(start.x, start.y);
        System.arraycopy(subpath, 0, path, 1, path.length - 1);
        return path;
    }
}