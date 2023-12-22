package org.example.view;

import org.example.*;
import org.example.controller.KeyController;
import org.example.Observer;
import org.example.model.Tetromino;
import org.example.model.TetrominoType;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class Board extends JPanel implements Observer {
    private JLabel statusBar;
    private boolean[][] board;
    int[][] currentElement;

    public Board(KeyController controller, Tetris parent) {
        setFocusable(true);
        statusBar = parent.getStatusBar();
        board = new boolean[AppConstants.BOARD_WIDTH][AppConstants.BOARD_HEIGHT];
        addKeyListener(controller);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Dimension size = getSize();
        int boardTop = (int) size.getHeight() - AppConstants.BOARD_HEIGHT * squareHeight();
        board[0][0] = true;
        board[9][21] = true;
        for (int x = 0; x < AppConstants.BOARD_WIDTH; ++x) {

            for (int y = 0; y < AppConstants.BOARD_HEIGHT; ++y) {
                if (board[x][y]) {
                    drawSquare(g, x * squareWidth(), boardTop + y * squareHeight());
                }
            }
        }
        if (currentElement != null) {
            for (int element = 0; element < 4; element++) {

                int ex = currentElement[element][0];
                int ey = currentElement[element][1];
                drawSquare(g, ex * squareWidth(), boardTop + ey * squareHeight());
            }
        }
    }

    private void drawSquare(Graphics g, int x, int y) {
        Color color = new Color(102, 204, 102);
        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);

        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);

        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + 1);
    }
    private int squareHeight() {
        return (int) getSize().getHeight() / AppConstants.BOARD_HEIGHT;
    }

    private int squareWidth() {
        return (int) getSize().getWidth() / AppConstants.BOARD_WIDTH;
    }

    public void setValue(int x, int y, boolean value) {
        board[x][y] = value;
    }

    @Override
    public void update(int[][] coordinates) {
        currentElement = coordinates;
        repaint();
    }
}
