package com.example.comp3111f23g05.manager;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class AudioManager {
    private static final int MAX_LOOP_TIME = 20;
    private Clip[] clips = new Clip[Sound.values().length]; //store the looping clip
    private static final AudioManager instance = new AudioManager();

    private AudioManager() {}
    public static AudioManager getInstance() {
        return instance;
    }


    public void play(Sound sound, boolean loop ){
        // multiple play() calls of bgm
        if(this.clips[sound.ordinal()] != null && this.clips[sound.ordinal()].isRunning() && loop){
            return;
        }
        //create a new clip for the sound
        URL url = AudioManager.class.getResource(sound.url);
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);

            // instant sound effect
            if(!loop){
                clip.start();
                return;
            }
            // bgm
            clip.loop(MAX_LOOP_TIME);
            this.clips[sound.ordinal()] = clip;

        } catch (Exception ignored) {
            System.out.println("There is an error in playing sound");
            return;
        }
    }

    public void stop(Sound sound){
        Clip clip = this.clips[sound.ordinal()];
        // stop if exist and is running
        if(clip != null && clip.isRunning()){
            clip.stop();
        }

    }

}
