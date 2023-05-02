package controller.command.sound;

import controller.command.IButtonCommand;
import controller.sound.BackgroundMusicControllerMonostate;
import controller.sound.IBackgroundMusicController;


public class SwitchToMainThemeCommand implements IButtonCommand {

    public SwitchToMainThemeCommand() {}

    @Override
    public void execute() {
        IBackgroundMusicController bgMusic = 
        BackgroundMusicControllerMonostate.createInstance();
        bgMusic.playMainTheme();
    }
}
