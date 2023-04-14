package controller.command.sound;

import controller.command.ButtonCommand;
import controller.sound.ButtonClipSoundSingleton;
import controller.sound.IButtonClipSoundController;

public class PlayClipCommand implements ButtonCommand {
    IButtonClipSoundController buttonClipSound = ButtonClipSoundSingleton.getInstance();

    public PlayClipCommand() {}

    @Override
    public void execute() {
        buttonClipSound.play();
    }
}