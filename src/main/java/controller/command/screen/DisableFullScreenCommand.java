package controller.command.screen;

import controller.command.IButtonCommand;
import controller.screen.FullScreenManagerSingleton;
import controller.screen.IFullScreenManagerController;

/**
 * A class that implements the IButtonCommand interface to disable full screen mode.
 * @author gerardocipriano
 */
public class DisableFullScreenCommand implements IButtonCommand {
    // instance of FullScreenManagerSingleton
    private IFullScreenManagerController fullScreenManager = FullScreenManagerSingleton.getInstance();

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