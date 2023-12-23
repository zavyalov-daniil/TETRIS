package org.example.command;

import org.example.model.Board;
import org.example.model.Tetromino;
import org.springframework.stereotype.Component;

@Component
public class CollisionChecker {
    Board board;

    public CollisionChecker(Board board) {
        this.board = board;
    }

    public boolean check(Tetromino movable, int deltaX, int deltaY) {
        for (int[] coords : movable.getCoordinates()) {
            if (board.containElement(coords[0] + deltaX, coords[1] + deltaY)) {
                return false;
            }
        }
        return true;
    }
}
