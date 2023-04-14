package controller.command.screen;

import controller.command.IButtonCommand;
import controller.screen.FullScreenManager;

/**
 * This class represents a command to enable full screen mode. It implements the IButtonCommand interface.
 * @author gerardocipriano.
 */
public class EnableFullScreenCommand implements IButtonCommand {
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
