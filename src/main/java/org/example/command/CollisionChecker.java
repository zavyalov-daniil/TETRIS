package org.example.command;

import org.example.AppConstants;
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
            int newX = coords[0] + deltaX;
            int newY = coords[1] + deltaY;
            if (board.containElement(newX, newY) || newX < 0 || newX >= AppConstants.BOARD_WIDTH || newY >= AppConstants.BOARD_HEIGHT) {
                if(deltaY != 0) {
                    movable.setDropped(true);
                }
                return false;
            }
        }
        if(deltaY != 0) {
            movable.setDropped(false);
        }
        return true;
    }
}
