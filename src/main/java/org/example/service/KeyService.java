package org.example.service;

import org.example.command.Command;
import org.example.command.factory.CommandFactory;
import org.example.command.factory.CommandFactoryImpl;
import org.example.model.Tetromino;
import org.example.model.TetrominoType;
import org.example.model.factory.TetrominoFactory;
import org.example.model.factory.TetrominoFactoryImpl;
import org.example.view.Board;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.security.KeyFactory;

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
