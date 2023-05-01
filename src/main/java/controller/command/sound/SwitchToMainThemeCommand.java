package controller.command.sound;

import controller.command.IButtonCommand;
import controller.sound.BackgroundMusicControllerSingleton;
import controller.sound.IBackgroundMusicController;

public class SwitchToMainThemeCommand implements IButtonCommand {

    public SwitchToMainThemeCommand() {}

    @Override
    public void execute() {
        IBackgroundMusicController backgroundMusicController = BackgroundMusicControllerSingleton.getInstance();
        backgroundMusicController.play("main");
    }
}
