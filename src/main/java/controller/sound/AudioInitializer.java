package controller.sound;

public class AudioInitializer {
    public static void initializeAudio() {
        IBackgroundMusicController bgMusic = 
            BackgroundMusicControllerMonostate.createInstance();
        bgMusic.playMainTheme();
        bgMusic.setVolume(0.035);
    }
}