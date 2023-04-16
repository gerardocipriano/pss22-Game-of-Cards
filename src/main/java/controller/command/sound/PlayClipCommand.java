package controller.command.sound;

import controller.command.IButtonCommand;
import controller.sound.ButtonClipSoundSingleton;
import controller.sound.IButtonClipSoundController;

public class PlayClipCommand implements IButtonCommand {
    IButtonClipSoundController buttonClipSound = ButtonClipSoundSingleton.getInstance();

    public PlayClipCommand() {}

    @Override
    public void execute() {
        buttonClipSound.play();
    }
}