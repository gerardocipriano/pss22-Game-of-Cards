package controller.sound;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.net.URL;

public class BackgroundMusic {
    private static BackgroundMusic instance;
    private MediaPlayer mediaPlayer;
    private Media mainTheme;
    private Media matchTheme;

    private BackgroundMusic() {
        URL resource1 = getClass().getResource("/sounds/music/MainTheme.mp3");
        URL resource2 = getClass().getResource("/sounds/music/MatchTheme.mp3");
        mainTheme = new Media(resource1.toString());
        matchTheme = new Media(resource2.toString());
        mediaPlayer = new MediaPlayer(mainTheme);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public static BackgroundMusic getInstance() {
        if (instance == null) {
            instance = new BackgroundMusic();
        }
        return instance;
    }

    public void playMainTheme() {
        mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(mainTheme);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void playMatchTheme() {
        mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(matchTheme);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void setVolume(double volume) {
        mediaPlayer.setVolume(volume);
    }

    public double getVolume() {
        return mediaPlayer.getVolume();
    }
}