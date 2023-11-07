package com.example.comp3111f23g05.Map;

public enum BlockType {
    BARRIER,
    CLEAR,
    ENTRY,
    EXIT,
    BOUNDARY;
    public boolean canArrive() {
        return !(this == BARRIER || this == BOUNDARY);
    }
    public boolean isEntry() {
        return this == ENTRY;
    }
    public boolean isExit() {
        return this == EXIT;
    }
    public boolean isBoundary() {return this == BOUNDARY; }
}