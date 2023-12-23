package org.example.service;

import org.example.command.Command;
import org.example.command.factory.CommandFactory;
import org.example.model.factory.TetrominoFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.awt.event.KeyEvent;

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
        Command command = null;
        switch (keycode) {
            case KeyEvent.VK_LEFT ->
                    command = commandFactory.getMoveCommand(tetrominoFactory.getCurrent(), -1, 0);
            case KeyEvent.VK_RIGHT ->
                    command = commandFactory.getMoveCommand(tetrominoFactory.getCurrent(), 1, 0);
            case KeyEvent.VK_DOWN ->
                    command = commandFactory.getMoveCommand(tetrominoFactory.getCurrent(), 0, 1);
            default -> commandFactory.getDefaultCommand();
        }
        command.execute();
    }
}
