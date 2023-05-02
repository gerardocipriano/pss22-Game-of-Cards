package controller.sound;

import java.util.List;

import javafx.scene.media.Media;

public interface IBackgroundMusicController {

    void playMainTheme();
    void playMatchTheme();
    void setVolume(double volume);
    double getVolume();
    int getCurrentMainThemeIndex();
    void setCurrentMainThemeIndex(int index);
    void setCurrentMatchThemeIndex(int index);
    int getCurrentMatchThemeIndex();
    List<Media> getMainThemeMediaList();
    List<Media> getMatchThemeMediaList();

}