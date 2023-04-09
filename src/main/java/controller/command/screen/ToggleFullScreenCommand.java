package controller.command.screen;

import controller.command.ButtonCommand;
import controller.screen.FullScreenManager;

public class ToggleFullScreenCommand implements ButtonCommand {

    public ToggleFullScreenCommand() {}

    @Override
    public void execute() {
        FullScreenManager.getInstance().toggleFullScreen();
    }
}
