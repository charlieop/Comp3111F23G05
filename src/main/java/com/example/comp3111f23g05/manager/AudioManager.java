package com.example.comp3111f23g05.manager;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import java.net.URL;

/**
 * The AudioManager class manages the audio playback in the game.
 * It uses the Java Sound API to play audio clips.
 */
public class AudioManager {

    /**
     * The maximum loop time for audio clips.
     */
    private static final int MAX_LOOP_TIME = 20;

    /**
     * An array of clips for each sound.
     */
    private Clip[] clips = new Clip[Sound.values().length];

    /**
     * The singleton instance of the AudioManager class.
     */
    private static final AudioManager instance = new AudioManager();

    /**
     * Private constructor to prevent instantiation.
     */
    private AudioManager() {}

    /**
     * Returns the singleton instance of the AudioManager class.
     *
     * @return The instance of the AudioManager class.
     */
    public static AudioManager getInstance() {
        return instance;
    }

    /**
     * Plays the specified sound.
     *
     * @param sound  The sound to play.
     * @param loop  Indicates whether the sound should be looped.
     */
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

    /**
     * Stops the specified sound.
     *
     * @param sound  The sound to stop.
     */
    public void stop(Sound sound){
        Clip clip = this.clips[sound.ordinal()];
        // stop if exist and is running
        if(clip != null && clip.isRunning()){
            clip.stop();
        }
    }
}
