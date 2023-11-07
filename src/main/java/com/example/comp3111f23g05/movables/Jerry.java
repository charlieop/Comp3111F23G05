package com.example.comp3111f23g05.movables;

public class Jerry implements Movables {
    private static final Jerry instance = new Jerry();
    private Jerry() {}
    public static Jerry getInstance() {
        return instance;
    }
}
