package controller.command.sound;

import controller.command.ButtonCommand;
import controller.sound.ButtonClipSound;

public class PlayClipCommand implements ButtonCommand {
    ButtonClipSound buttonClipSound = ButtonClipSound.getInstance();

    public PlayClipCommand() {}

    @Override
    public void execute() {
        buttonClipSound.play();
    }
}