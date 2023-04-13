package controller.command;

import java.util.List;

/**
 * MacroCommand is an implementation of the ButtonCommand interface that allows a group of commands to be executed together.
 *
 * @author @gerardocipriano
 */
public class MacroCommand implements ButtonCommand {

    /**
     * The list of commands to be executed in sequence.
     */
    private List<ButtonCommand> commands;

    /**
     * Constructs a new MacroCommand object with the given list of ButtonCommands.
     *
     * @param commands the commands to be executed
     */
    public MacroCommand(List<ButtonCommand> commands) {
        this.commands = commands;
    }

    /**
     * Executes each command in the list in sequence.
     */
    @Override
    public void execute() {
        for (ButtonCommand command : commands) {
            command.execute();
        }
    }
}
