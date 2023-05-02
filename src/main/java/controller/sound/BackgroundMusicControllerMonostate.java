package controller.sound;

import javafx.scene.media.Media;

import java.util.List;

/**
 * This class represents a Monostate that controls the background music of the application.
 * It allows to play different themes and to change the volume of the music.
 * @author gerardocipriano
 */
 
 public class BackgroundMusicControllerMonostate implements IBackgroundMusicController {
    private MediaPlayerControllerSingleton mediaPlayerController = MediaPlayerControllerSingleton.getInstance();
    private static List<Media> mainThemeMediaList;

    private static List<Media> matchThemeMediaList;
    private static int currentMainThemeIndex;
    private static int currentMatchThemeIndex;

    public BackgroundMusicControllerMonostate(List<Media> mainThemeMediaList, List<Media> matchThemeMediaList) {
        BackgroundMusicControllerMonostate.mainThemeMediaList = mainThemeMediaList;
        BackgroundMusicControllerMonostate.matchThemeMediaList = matchThemeMediaList;
    }

    public static BackgroundMusicControllerMonostate createInstance() {
        AudioLoaderSingleton audioLoader = AudioLoaderSingleton.getInstance();
        return new BackgroundMusicControllerMonostate(audioLoader.getMainThemeMediaList(), audioLoader.getMatchThemeMediaList());
    }

    public void playMainTheme() {
        mediaPlayerController.play(mainThemeMediaList.get(currentMainThemeIndex));
    }

    public void playMatchTheme() {
        mediaPlayerController.play(matchThemeMediaList.get(currentMatchThemeIndex));
    }

    public void setCurrentMainThemeIndex(int index) {
        currentMainThemeIndex = index;
    }

    public void setCurrentMatchThemeIndex(int index) {
        currentMatchThemeIndex = index;
    }

    public void setVolume(double volume) {
        mediaPlayerController.setVolume(volume);
    }

    public double getVolume() {
        return mediaPlayerController.getVolume();
    }

    public int getCurrentMainThemeIndex() {
        return currentMainThemeIndex;
    }

    public int getCurrentMatchThemeIndex() {
        return currentMatchThemeIndex;
    }

    public List<Media> getMainThemeMediaList() {
        return mainThemeMediaList;
    }

    public List<Media> getMatchThemeMediaList() {
        return matchThemeMediaList;
    }
}