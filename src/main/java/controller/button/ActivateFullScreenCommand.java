package controller.button;

import controller.screen.FullScreenManager;

public class ActivateFullScreenCommand implements ButtonCommand {
    private FullScreenManager fullScreenManager = FullScreenManager.getInstance();

    public ActivateFullScreenCommand() {}

    @Override
    public void execute() {
        if (!fullScreenManager.isFullScreen()) {
            fullScreenManager.toggleFullScreen();
        }
    }
}
