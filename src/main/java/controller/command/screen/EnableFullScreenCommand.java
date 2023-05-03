package controller.command.screen;

import controller.command.IButtonCommand;
import controller.screen.FullScreenSingleton;
import controller.screen.IFullScreenController;

/**
 * This class represents a command to enable full screen mode. It implements the IButtonCommand interface.
 * @author gerardocipriano.
 */
public class EnableFullScreenCommand implements IButtonCommand {
    // instance of FullScreenManagerSingleton
    private IFullScreenController fullScreenManager = FullScreenSingleton.getInstance();

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
