package controller.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.List;

/**
 * This class represents a singleton that controls the background music of the application.
 * It allows to play different themes and to change the volume of the music.
 * @author gerardocipriano
 */
public class BackgroundMusicControllerSingleton implements IBackgroundMusicController {
    private static BackgroundMusicControllerSingleton instance;
    private MediaPlayer mediaPlayer;
    private List<Media> mainThemeMediaList;
    private List<Media> matchThemeMediaList;
    private int currentMainThemeIndex;

    private int currentMatchThemeIndex;

    /**
     * Private constructor to prevent instantiation from outside the class.
     */
    private BackgroundMusicControllerSingleton() {
        // empty initialization
    }

    /**
     * Returns the singleton instance of this class.
     * @return The singleton instance of this class.
     */
    public static BackgroundMusicControllerSingleton getInstance() {
        if (instance == null) {
            instance = new BackgroundMusicControllerSingleton();
        }
        return instance;
    }

    /**
     * Initializes the singleton with the lists of audio tracks for the main menu and for the match.
     * @param mainThemeMediaList The list of audio tracks for the main menu.
     * @param matchThemeMediaList The list of audio tracks for the match.
     */
    @Override
    public void init(List<Media> mainThemeMediaList, List<Media> matchThemeMediaList) {
        this.mainThemeMediaList = mainThemeMediaList;
        this.matchThemeMediaList = matchThemeMediaList;
        currentMainThemeIndex = 0;
        currentMatchThemeIndex = 0;
        mediaPlayer = new MediaPlayer(mainThemeMediaList.get(currentMainThemeIndex));
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }

    /**
     * Plays the specified theme.
     * @param theme The theme to play ("main" or "match").
     */
    public void play(String theme) {
        double currentVolume = mediaPlayer.getVolume();
        mediaPlayer.stop();
        if (theme.equals("main")) {
            mediaPlayer = new MediaPlayer(mainThemeMediaList.get(currentMainThemeIndex));
        } else if (theme.equals("match")) {
            mediaPlayer = new MediaPlayer(matchThemeMediaList.get(currentMatchThemeIndex));
        }
        mediaPlayer.setVolume(currentVolume);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    /**
     * Sets the index of the current main theme to play.
     * @param index The index of the main theme to play.
     */
    public void setCurrentMainThemeIndex(int index) {
        currentMainThemeIndex = index;
    }

    /**
     * Sets the index of the current match theme to play.
     * @param index The index of the match theme to play.
     */
    public void setCurrentMatchThemeIndex(int index) {
        currentMatchThemeIndex = index;
    }

    /**
     * Sets the volume of the music.
     * @param volume The volume of the music (between 0.0 and 1.0).
     */
    public void setVolume(double volume) {
        mediaPlayer.setVolume(volume);
    }

    /**
     * Returns the current volume of the music.
     * @return The current volume of the music (between 0.0 and 1.0).
     */
    public double getVolume() {
        return mediaPlayer.getVolume();
    }

    public int getCurrentMainThemeIndex() {
        return currentMainThemeIndex;
    }

    public int getCurrentMatchThemeIndex() {
        return currentMatchThemeIndex;
    }

}