package controller.command.sound;

import controller.command.ButtonCommand;
import controller.sound.BackgroundMusicSingleton;
import controller.sound.IBackgroundMusicController;

public class SwitchToMainThemeCommand implements ButtonCommand {

    public SwitchToMainThemeCommand() {}

    @Override
    public void execute() {
        IBackgroundMusicController backgroundMusicController = BackgroundMusicSingleton.getInstance();
        backgroundMusicController.play("main");
    }
}
