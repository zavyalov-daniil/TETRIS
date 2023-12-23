package org.example.model.factory;

import org.example.model.Tetromino;
import org.example.model.TetrominoType;
import org.example.view.BoardView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TetrominoFactoryImpl implements TetrominoFactory {
    BoardView boardView;
    Tetromino currentTetromino;

    public TetrominoFactoryImpl() {
    }

    @Autowired
    @Lazy
    public void setBoard(BoardView boardView) {
        this.boardView = boardView;
    }

    @Override
    public Tetromino createRandomTetromino() {
        currentTetromino = new Tetromino(TetrominoType.LShape, 4, 0);
        boardView.update(currentTetromino.getCoordinates());
        currentTetromino.registerObserver(boardView);
        return currentTetromino;
    }

    @Override
    public Tetromino getCurrent() {
        if (currentTetromino == null) {
            currentTetromino = createRandomTetromino();
        }
        return currentTetromino;
    }
}
