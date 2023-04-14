package controller.command.screen;

import controller.command.IButtonCommand;
import controller.screen.FullScreenManagerSingleton;
import controller.screen.IFullScreenManagerController;

/**
 * The ToggleFullScreenCommand class implements the IButtonCommand interface and allows toggling 
 * the full screen mode of the application. 
 * 
 * @author gerardocipriano
 */
public class ToggleFullScreenCommand implements IButtonCommand {

    private IFullScreenManagerController fullScreenManager = FullScreenManagerSingleton.getInstance();
    /**
     * Constructs a new ToggleFullScreenCommand instance.
     */
    public ToggleFullScreenCommand() {}
    
    /**
     * Executes the command, toggling the full screen mode of the application.
     */
    @Override
    public void execute() {
        fullScreenManager.toggleFullScreen();
    }
}
