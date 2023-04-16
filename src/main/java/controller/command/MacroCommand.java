package controller.command;

import java.util.List;

/**
 * MacroCommand is an implementation of the IButtonCommand interface that allows a group of commands to be executed together.
 *
 * @author gerardocipriano
 */
public class MacroCommand implements IButtonCommand {

    /**
     * The list of commands to be executed in sequence.
     */
    private List<IButtonCommand> commands;

    /**
     * Constructs a new MacroCommand object with the given list of IButtonCommands.
     *
     * @param commands the commands to be executed
     */
    public MacroCommand(List<IButtonCommand> commands) {
        this.commands = commands;
    }

    /**
     * Executes each command in the list in sequence.
     */
    @Override
    public void execute() {
        for (IButtonCommand command : commands) {
            command.execute();
        }
    }
}
