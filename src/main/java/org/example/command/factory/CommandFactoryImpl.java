package org.example.command.factory;

import org.example.command.Command;
import org.example.command.commands.MoveCommand;
import org.example.model.Tetromino;
import org.springframework.stereotype.Component;

@Component
public class CommandFactoryImpl implements CommandFactory {

    @Override
    public Command getMoveCommand(Tetromino movable, int deltaX, int deltaY) {
        return new MoveCommand(movable, deltaX, deltaY);
    }
}
