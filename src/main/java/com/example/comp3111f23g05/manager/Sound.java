package com.example.comp3111f23g05.manager;

public enum Sound {
        ALERT("/sounds/alert.wav"),
        BLOCK("/sounds/block flick.wav"),
        BUTTON("/sounds/button.wav"),
        DONE("/sounds/done.wav"),
        THEME("/sounds/themeSong.wav"),
        GAME("/sounds/gameSong.wav"),
        JERRY("/sounds/Jerry.wav"),
        VICTORY( "/sounds/victory.wav"),
        FAILURE("/sounds/failure.wav");

        public final String url;
         Sound(String url) {
                 this.url = url;
         }
}
