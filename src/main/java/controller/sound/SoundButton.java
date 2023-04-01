package controller.sound;

import javafx.scene.control.Button;

public class SoundButton extends Button {
    public SoundButton(String text) {
        super(text);
    }

    public static SoundButton create() {
        return new SoundButton("My Button");
    }
    
    @Override
    public void fire() {
        ButtonClipSound.getInstance().play();
        super.fire();
    }
}