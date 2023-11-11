package com.example.comp3111f23g05.manager;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class AudioManager {
    private static final int MAX_LOOP_TIME = 20;
    private Clip clip; //store the looping clip
    private static final AudioManager instance = new AudioManager();
    private final String[] soundFiles = {
            "/sounds/alert.wav",
            "/sounds/block flick.wav",
            "/sounds/button.wav",
            "/sounds/done.wav",
            "/sounds/themeSong.wav",
            "/sounds/gameSong.wav"
    };

    private AudioManager() {}
    public static AudioManager getInstance() {
        return instance;
    }


    public void play(Sound sound) {
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

            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void play(Sound sound, boolean loop ){
        if(!loop){
            play(sound);
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

            clip.loop(MAX_LOOP_TIME);
            this.clip = clip;
//            Clip[] clips = this.clips;
//            this.clips = new Clip[this.clips.length+1];
//            System.arraycopy(clips,0,this.clips,0, clips.length);
//            this.clips[clips.length-1] = clip;
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop(){
        this.clip.stop();
//        this.clips[pos].stop();
//        Clip[] clips = this.clips;
//        this.clips = new Clip[this.clips.length-1];
//        System.arraycopy(clips,0,this.clips,0, pos+1);
//        System.arraycopy(clips,pos+1,this.clips,pos, clips.length-pos-1);
    }



}
