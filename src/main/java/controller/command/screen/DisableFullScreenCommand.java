package controller.command.screen;

import controller.command.ButtonCommand;
import controller.screen.FullScreenManager;

/**
 * A class that implements the ButtonCommand interface to disable full screen mode.
 * @author gerardocipriano
 */
public class DisableFullScreenCommand implements ButtonCommand {
    // instance of FullScreenManager
    private FullScreenManager fullScreenManager = FullScreenManager.getInstance();

    /**
     * Constructor for DisableFullScreenCommand.
     */
    public DisableFullScreenCommand() {}

    /**
     * Executes the command to disable full screen mode.
     */
    @Override
    public void execute() {
        // check if not in full screen, then toggle full screen mode
        if (!fullScreenManager.isFullScreen()) {
            fullScreenManager.toggleFullScreen();
        }
    }
}