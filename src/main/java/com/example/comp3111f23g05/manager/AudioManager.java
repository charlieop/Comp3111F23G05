package com.example.comp3111f23g05.manager;

public class AudioManager {
    private static final AudioManager instance = new AudioManager();
    private AudioManager() {}
    public static AudioManager getInstance() {
        return instance;
    }
}
