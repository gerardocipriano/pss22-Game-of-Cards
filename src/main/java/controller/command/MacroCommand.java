package controller.command;

import java.util.List;

public class MacroCommand implements ButtonCommand {
    private List<ButtonCommand> commands;

    public MacroCommand(List<ButtonCommand> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (ButtonCommand command : commands) {
            command.execute();
        }
    }
}
