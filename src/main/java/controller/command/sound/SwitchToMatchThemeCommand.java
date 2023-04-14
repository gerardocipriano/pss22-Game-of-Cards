package controller.command.sound;

import controller.command.IButtonCommand;
import controller.sound.BackgroundMusicSingleton;
import controller.sound.IBackgroundMusicController;

public class SwitchToMatchThemeCommand implements IButtonCommand {

    public SwitchToMatchThemeCommand() {}

    @Override
    public void execute() {
        IBackgroundMusicController backgroundMusicController = BackgroundMusicSingleton.getInstance();
        backgroundMusicController.play("match");
    }
}
