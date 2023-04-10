package controller.command.screen;

import controller.command.ButtonCommand;
import controller.screen.FullScreenManager;

public class DisableFullScreenCommand implements ButtonCommand {
    private FullScreenManager fullScreenManager = FullScreenManager.getInstance();

    public DisableFullScreenCommand() {}

    @Override
    public void execute() {
        if (!fullScreenManager.isFullScreen()) {
            fullScreenManager.toggleFullScreen();
        }
    }
}