package com.example.comp3111f23g05.manager;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class AudioManager {
    private static final int MAX_LOOP_TIME = 20;
    private Clip[] clips = new Clip[Sound.values().length]; //store the looping clip
    private static final AudioManager instance = new AudioManager();
    private final String[] soundFiles = {
            "/sounds/alert.wav",
            "/sounds/block flick.wav",
            "/sounds/button.wav",
            "/sounds/done.wav",
            "/sounds/themeSong.wav",
            "/sounds/gameSong.wav",
            "/sounds/Jerry.wav",
            "/sounds/victory.wav",
            "/sounds/failure.wav"
    };

    private AudioManager() {}
    public static AudioManager getInstance() {
        return instance;
    }


    public void play(Sound sound, boolean loop ){

        if(this.clips[sound.ordinal()] != null && this.clips[sound.ordinal()].isRunning() && loop){
            return;
        }

        String fileName = soundFiles[sound.ordinal()];
        URL url = AudioManager.class.getResource(fileName);
        if(url == null){
            System.out.println("can not find file named: " + fileName);
        }
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);

            if(!loop){
                clip.start();
                return;
            }

            stop(sound);
            clip.loop(MAX_LOOP_TIME);
            this.clips[sound.ordinal()] = clip;

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop(Sound sound){
        Clip clip = this.clips[sound.ordinal()];
        if(clip != null && clip.isRunning()){
            clip.stop();
        }

    }



}
