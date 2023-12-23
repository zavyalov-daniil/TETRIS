package org.example.command.factory;

import org.example.command.CollisionChecker;
import org.example.command.Command;
import org.example.command.commands.MoveCommand;
import org.example.command.commands.MultiCommand;
import org.example.command.commands.RemoveRowsCommand;
import org.example.model.Board;
import org.example.model.Tetromino;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CommandFactoryImpl implements CommandFactory {
    CollisionChecker collisionChecker;

    public CommandFactoryImpl(CollisionChecker collisionChecker) {
        this.collisionChecker = collisionChecker;
    }

    @Override
    public Command getMoveCommand(Tetromino movable, int deltaX, int deltaY) {
        return new MoveCommand(movable, deltaX, deltaY, collisionChecker);
    }

    @Override
    public Command getDefaultCommand() {
        return new MultiCommand(new ArrayList<>());
    }

    @Override
    public Command getRemoveRowsCommand(Board board) {
        return new RemoveRowsCommand(board);
    }


}
