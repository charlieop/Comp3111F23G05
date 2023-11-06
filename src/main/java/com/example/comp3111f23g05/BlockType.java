package com.example.comp3111f23g05;

public enum Block {
    BARRIER,
    CLEAR,
    ENTRY,
    EXIT;
    public boolean canArrive() {
        return !(this == BARRIER);
    }
    public boolean isEntry() {
        return this == ENTRY;
    }
    public boolean isExit() {
        return this == EXIT;
    }
}
