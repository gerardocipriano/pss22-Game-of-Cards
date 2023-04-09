package controller.button;

import controller.screen.FullScreenManager;

public class ToggleFullScreenCommand implements ButtonCommand {

    public ToggleFullScreenCommand() {}

    @Override
    public void execute() {
        FullScreenManager.getInstance().toggleFullScreen();
    }
}
