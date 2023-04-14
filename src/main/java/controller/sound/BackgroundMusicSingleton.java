package controller.sound;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.net.URL;

public class BackgroundMusicSingleton implements IBackgroundMusicController {
    private static BackgroundMusicSingleton instance;
    private MediaPlayer mediaPlayer;
    private Media mainTheme;
    private Media matchTheme;

    private BackgroundMusicSingleton() {
        URL resource1 = getClass().getResource("/sounds/music/MainTheme.mp3");
        URL resource2 = getClass().getResource("/sounds/music/MatchTheme.mp3");
        mainTheme = new Media(resource1.toString());
        matchTheme = new Media(resource2.toString());
        mediaPlayer = new MediaPlayer(mainTheme);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public static BackgroundMusicSingleton getInstance() {
        if (instance == null) {
            instance = new BackgroundMusicSingleton();
        }
        return instance;
    }
    
    public void play(String theme) {
        double currentVolume = mediaPlayer.getVolume();
        mediaPlayer.stop();
        if (theme.equals("main")) {
            mediaPlayer = new MediaPlayer(mainTheme);
        } else if (theme.equals("match")) {
            mediaPlayer = new MediaPlayer(matchTheme);
        }
        mediaPlayer.setVolume(currentVolume);
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