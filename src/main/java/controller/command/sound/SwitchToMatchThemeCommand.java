package controller.command.sound;

import controller.command.ButtonCommand;
import controller.sound.BackgroundMusic;

public class SwitchToMatchThemeCommand implements ButtonCommand {

    public SwitchToMatchThemeCommand() {}

    @Override
    public void execute() {
        BackgroundMusic.getInstance().playMatchTheme();
    }
    
}
