package org.example.command.factory;

import org.example.command.Command;
import org.example.model.Tetromino;
import org.springframework.stereotype.Component;

public interface CommandFactory {
    Command getMoveCommand(Tetromino movable, int deltaX, int deltaY);
}
