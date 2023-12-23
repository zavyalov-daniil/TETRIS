package org.example.command.commands;

import org.example.command.Command;
import org.example.model.Board;

public class RemoveRowsCommand implements Command {
    Board board;

    public RemoveRowsCommand(Board board) {
        this.board = board;
    }

    @Override
    public void execute() {
        for (int[] elements : board.getElements()) {

        }
    }
}
