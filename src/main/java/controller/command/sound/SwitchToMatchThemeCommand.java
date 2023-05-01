package controller.command.sound;

import controller.command.IButtonCommand;
import controller.sound.BackgroundMusicControllerSingleton;
import controller.sound.IBackgroundMusicController;

public class SwitchToMatchThemeCommand implements IButtonCommand {

    public SwitchToMatchThemeCommand() {}

    @Override
    public void execute() {
        IBackgroundMusicController backgroundMusicController = BackgroundMusicControllerSingleton.getInstance();
        backgroundMusicController.play("match");
    }
}
