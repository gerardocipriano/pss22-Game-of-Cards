package controller.button;

import controller.screen.FullScreenManager;

public class ActivateFullScreenCommand implements ButtonCommand {
    private FullScreenManager fullScreenManager;

    public ActivateFullScreenCommand(FullScreenManager fullScreenManager) {
        this.fullScreenManager = fullScreenManager;
    }

    @Override
    public void execute() {
        if (!fullScreenManager.isFullScreen()) {
            fullScreenManager.toggleFullScreen();
        }
    }
}
