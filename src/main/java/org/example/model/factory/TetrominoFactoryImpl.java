package org.example.model.factory;

import org.example.model.Tetromino;
import org.example.model.TetrominoType;
import org.example.view.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TetrominoFactoryImpl implements TetrominoFactory {
    Board board;
    Tetromino tetromino;

    public TetrominoFactoryImpl() {
    }

    @Autowired
    @Lazy
    public void setBoard(Board board) {
        this.board = board;
        tetromino = new Tetromino(TetrominoType.LShape, 4, 2);
    }

    @Override
    public Tetromino createRandomTetromino() {
        tetromino.registerObserver(board);
        return tetromino;
    }
}
