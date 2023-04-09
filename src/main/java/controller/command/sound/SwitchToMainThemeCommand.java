package controller.command.sound;

import controller.command.ButtonCommand;
import controller.sound.BackgroundMusic;

public class SwitchToMainThemeCommand implements ButtonCommand {

    public SwitchToMainThemeCommand() {}

    @Override
    public void execute() {
        BackgroundMusic.getInstance().playMainTheme();
    }
}
