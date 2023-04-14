package controller.sound;

public interface IBackgroundMusicController {

    void play(String theme);
    void setVolume(double volume);
    double getVolume();

}