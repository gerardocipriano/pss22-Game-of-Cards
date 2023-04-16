package controller.command.sound;

import controller.command.IButtonCommand;
import controller.sound.BackgroundMusicSingleton;
import controller.sound.IBackgroundMusicController;

public class SwitchToMainThemeCommand implements IButtonCommand {

    public SwitchToMainThemeCommand() {}

    @Override
    public void execute() {
        IBackgroundMusicController backgroundMusicController = BackgroundMusicSingleton.getInstance();
        backgroundMusicController.play("main");
    }
}
