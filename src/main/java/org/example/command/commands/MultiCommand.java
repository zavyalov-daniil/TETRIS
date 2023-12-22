package org.example.command.commands;

import org.example.command.Command;

import java.util.Collection;

public class MultiCommand implements Command {
    public Collection<Command> commands;

    public MultiCommand(Collection<Command> commands) {
        this.commands = commands;
    }
    @Override
    public void execute() {
        for (Command cmd : commands) {
            cmd.execute();
        }
    }
}
