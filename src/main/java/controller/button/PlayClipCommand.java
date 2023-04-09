package controller.button;

import controller.sound.ButtonClipSound;

public class PlayClipCommand implements ButtonCommand {
    private ButtonClipSound buttonClipSound;

    public PlayClipCommand(ButtonClipSound buttonClipSound) {
        this.buttonClipSound = buttonClipSound;
    }

    @Override
    public void execute() {
        buttonClipSound.play();
    }
}