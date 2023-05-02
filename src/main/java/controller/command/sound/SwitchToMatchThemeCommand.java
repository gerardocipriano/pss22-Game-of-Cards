package controller.command.sound;

import controller.command.IButtonCommand;
import controller.sound.BackgroundMusicControllerMonostate;
import controller.sound.IBackgroundMusicController;

public class SwitchToMatchThemeCommand implements IButtonCommand {

    public SwitchToMatchThemeCommand() {}

    @Override
    public void execute() {
        IBackgroundMusicController bgMusic = 
        BackgroundMusicControllerMonostate.createInstance();
        bgMusic.playMatchTheme();
    }
}
