package org.example.command.commands;


import org.example.command.Command;
import org.example.model.Tetromino;

public class MoveCommand implements Command {
    Tetromino movable;
    int deltaX;
    int deltaY;

    public MoveCommand(Tetromino movable, int deltaX, int deltaY) {
        this.movable = movable;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    @Override
    public void execute() {
        int[][] coords = movable.getCoordinates();
        for (int[] xy : coords) {
            xy[0] = xy[0] + deltaX;
            xy[1] = xy[1] + deltaY;
        }
        movable.setCoordinates(coords);
    }
}
