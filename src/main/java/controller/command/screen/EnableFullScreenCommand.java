package controller.command.screen;

import controller.command.ButtonCommand;
import controller.screen.FullScreenManager;

/**
 * This class represents a command to enable full screen mode. It implements the ButtonCommand interface.
 * @author gerardocipriano.
 */
public class EnableFullScreenCommand implements ButtonCommand {
    private FullScreenManager fullScreenManager = FullScreenManager.getInstance();

    /**
     * Constructs an instance of the EnableFullScreenCommand class.
     */
    public EnableFullScreenCommand() {}

    /**
     * Executes the command to enable full screen mode.
     */
    @Override
    public void execute() {
        if (!fullScreenManager.isFullScreen()) {
            fullScreenManager.toggleFullScreen();
        }
    }
}
