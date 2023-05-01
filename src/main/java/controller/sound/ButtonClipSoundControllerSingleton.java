package controller.sound;

import javafx.scene.media.AudioClip;
import java.net.URL;

public class ButtonClipSoundControllerSingleton implements IButtonClipSoundController {
    private static ButtonClipSoundControllerSingleton instance;
    private AudioClip buttonClipSound;
    


    private ButtonClipSoundControllerSingleton() {
        URL resource = getClass().getResource("/sounds/clip/buttonClipSound.mp3");
        buttonClipSound = new AudioClip(resource.toString());
    }

    public static ButtonClipSoundControllerSingleton getInstance() {
        if (instance == null) {
            instance = new ButtonClipSoundControllerSingleton();
        }
        return instance;
    }

    public void play() {
        buttonClipSound.setVolume(0.1);
        buttonClipSound.play();
        
    }
}
