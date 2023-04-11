package controller.command.screen;

import controller.command.ButtonCommand;
import controller.screen.FullScreenManager;

public class EnableFullScreenCommand implements ButtonCommand {
    private FullScreenManager fullScreenManager = FullScreenManager.getInstance();

    public EnableFullScreenCommand() {}

    @Override
    public void execute() {
        if (!fullScreenManager.isFullScreen()) {
            fullScreenManager.toggleFullScreen();
        }
    }
}
