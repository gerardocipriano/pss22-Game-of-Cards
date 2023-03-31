package controller.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;

public class BackgroundMusic {

    private static BackgroundMusic instance;
    private MediaPlayer mediaPlayer;

    private BackgroundMusic() {
        URL resource = getClass().getResource("/sounds/music/MainTheme.mp3");
        Media sound = new Media(resource.toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public static BackgroundMusic getInstance() {
        if (instance == null) {
            instance = new BackgroundMusic();
        }
        return instance;
    }

    public void play() {
        mediaPlayer.play();
    }

    public void setVolume(double volume) {
        mediaPlayer.setVolume(volume);
    }
}