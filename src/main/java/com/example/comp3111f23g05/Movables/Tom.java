package com.example.comp3111f23g05.Movables;

public class Tom implements Movables{
    private static final Tom instance = new Tom();
    private Tom() {}
    public static Tom getInstance() {
        return instance;
    }
}
