package controller.sound;

import javafx.scene.media.AudioClip;
import java.net.URL;

public class ButtonClipSound {
    private static ButtonClipSound instance;
    private AudioClip buttonClipSound;
    


    private ButtonClipSound() {
        URL resource = getClass().getResource("/sounds/clip/buttonClipSound.mp3");
        buttonClipSound = new AudioClip(resource.toString());
    }

    public static ButtonClipSound getInstance() {
        if (instance == null) {
            instance = new ButtonClipSound();
        }
        return instance;
    }

    public void play() {
        buttonClipSound.setVolume(0.1);
        buttonClipSound.play();
        
    }
}
