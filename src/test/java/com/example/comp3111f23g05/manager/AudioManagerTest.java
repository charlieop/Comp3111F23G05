package com.example.comp3111f23g05.manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudioManagerTest {

    AudioManager audioManager = AudioManager.getInstance();
    @Test
    public void BGMTest(){
        // all are target functions

        // bgm sound, with looping and stop
        audioManager.play(Sound.THEME, true);
        audioManager.play(Sound.THEME, true);//multiple calls of play() on the same sound
        audioManager.stop(Sound.THEME);
        // call stop() when the sound is not playing
        audioManager.stop(Sound.THEME);
    }

    @Test
    public  void BGMSpecialTestCase(){
        // call stop() when haven't play a sound
        audioManager.stop(Sound.GAME);
    }

    @Test
    public  void instantTest(){
        // instant sound effect
        audioManager.play(Sound.BUTTON, false);
        audioManager.play(Sound.JERRY, false);

    }

}