package controller.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MediaPlayerControllerSingleton {
    private static MediaPlayerControllerSingleton instance;
    private MediaPlayer mediaPlayer;

    private MediaPlayerControllerSingleton() {
    }

    public static MediaPlayerControllerSingleton getInstance() {
        if (instance == null) {
            instance = new MediaPlayerControllerSingleton();
        }
        return instance;
    }

    public void play(Media media) {
        double currentVolume = 0;
        if (mediaPlayer != null) {
            currentVolume = mediaPlayer.getVolume();
            mediaPlayer.stop();
        }
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(currentVolume);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void setVolume(double volume) {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(volume);
        }
    }
    
    public double getVolume() {
        if (mediaPlayer != null) {
            return mediaPlayer.getVolume();
        } else {
            return 0;
        }
    }
}
