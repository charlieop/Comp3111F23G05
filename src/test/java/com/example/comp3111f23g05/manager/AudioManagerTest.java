package com.example.comp3111f23g05.manager;

import org.junit.jupiter.api.Test;

class AudioManagerTest {

    AudioManager audioManager = AudioManager.getInstance();
    @Test
    public void StopTest() throws InterruptedException {
        // call stop() when haven't play a sound
        audioManager.stop(Sound.GAME); //target function

        // bgm sound, with looping and stop
        audioManager.play(Sound.THEME, true);
        Thread.sleep(1000);
        audioManager.stop(Sound.THEME); //target function
        Thread.sleep(1000);
        // call stop() when the sound is not playing
        audioManager.stop(Sound.THEME); //target function
    }

    @Test
    public  void PlayTest()throws InterruptedException{
        // bgm sound, with looping
        audioManager.play(Sound.THEME, true);//target function
        Thread.sleep(1000);
        // multiple calls of play() on the same sound
        audioManager.play(Sound.THEME, true);//target function
        Thread.sleep(1000);

        // instant sound effect
        audioManager.play(Sound.BUTTON, false); //target function
        Thread.sleep(300);
        
        // invalid url
        audioManager.play(Sound.INVALID_TEST, false); //target function

    }

}