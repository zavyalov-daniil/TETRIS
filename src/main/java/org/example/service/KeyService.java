package org.example.service;

import org.example.command.Command;
import org.example.command.factory.CommandFactory;
import org.example.model.factory.TetrominoFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
public class KeyService {
    CommandFactory commandFactory;
    TetrominoFactory tetrominoFactory;

    public KeyService(CommandFactory commandFactory, TetrominoFactory tetrominoFactory) {
        this.commandFactory = commandFactory;
        this.tetrominoFactory = tetrominoFactory;
    }


    public void handleKeyEvent(int keycode) {
        System.out.println("a");
        Command command = commandFactory.getMoveCommand(tetrominoFactory.createRandomTetromino(), 0, 1);
        command.execute();
    }
}
