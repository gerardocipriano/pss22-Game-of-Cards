package controller.sound;

import java.util.List;

import javafx.scene.media.Media;

public interface IBackgroundMusicController {

    void play(String theme);
    void init (List<Media> mainThemeMediaList, List<Media> matchThemeMediaList);
    void setVolume(double volume);
    double getVolume();

}