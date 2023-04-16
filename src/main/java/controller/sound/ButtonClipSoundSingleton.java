package controller.sound;

import javafx.scene.media.AudioClip;
import java.net.URL;

public class ButtonClipSoundSingleton implements IButtonClipSoundController {
    private static ButtonClipSoundSingleton instance;
    private AudioClip buttonClipSound;
    


    private ButtonClipSoundSingleton() {
        URL resource = getClass().getResource("/sounds/clip/buttonClipSound.mp3");
        buttonClipSound = new AudioClip(resource.toString());
    }

    public static ButtonClipSoundSingleton getInstance() {
        if (instance == null) {
            instance = new ButtonClipSoundSingleton();
        }
        return instance;
    }

    public void play() {
        buttonClipSound.setVolume(0.1);
        buttonClipSound.play();
        
    }
}
