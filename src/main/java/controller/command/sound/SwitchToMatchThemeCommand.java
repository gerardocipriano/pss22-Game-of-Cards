package controller.command.sound;

import controller.command.ButtonCommand;
import controller.sound.BackgroundMusicSingleton;
import controller.sound.IBackgroundMusicController;

public class SwitchToMatchThemeCommand implements ButtonCommand {

    public SwitchToMatchThemeCommand() {}

    @Override
    public void execute() {
        IBackgroundMusicController backgroundMusicController = BackgroundMusicSingleton.getInstance();
        backgroundMusicController.play("match");
    }
}
