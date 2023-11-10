package com.example.comp3111f23g05.manager;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class AudioManager {
    private static final AudioManager instance = new AudioManager();
    private AudioManager() {}
    public static AudioManager getInstance() {
        return instance;
    }

    public void play(String fileName) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        URL url = AudioManager.class.getResource(fileName);
        if(url == null){
            System.out.println("can not find file named: " + fileName);
            return;
        }
        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
        Clip clip = (Clip) AudioSystem.getLine(info);
        clip.open(ais);

        clip.start();
    }

}
