package controller.command.sound;

import controller.command.IButtonCommand;
import controller.sound.ButtonClipSoundControllerSingleton;
import controller.sound.IButtonClipSoundController;

public class PlayClipCommand implements IButtonCommand {
    IButtonClipSoundController buttonClipSound = ButtonClipSoundControllerSingleton.getInstance();

    public PlayClipCommand() {}

    @Override
    public void execute() {
        buttonClipSound.play();
    }
}