package org.example.view;

import org.example.*;
import org.example.controller.KeyController;
import org.example.Observer;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

@Component
public class BoardView extends JPanel implements Observer {
    private JLabel statusBar;
    //private boolean[][] board;
    private HashSet<int[]> elements;
    private int[][] currentElement;

    public BoardView(KeyController controller, Tetris parent) {
        setFocusable(true);
        statusBar = parent.getStatusBar();
        //board = new boolean[AppConstants.BOARD_WIDTH][AppConstants.BOARD_HEIGHT];
        addKeyListener(controller);
        elements = new HashSet<>();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Dimension size = getSize();
        int boardTop = (int) size.getHeight() - AppConstants.BOARD_HEIGHT * squareHeight();
        //board[0][0] = true;
        //board[9][21] = true;
        elements.add(new int[] { 0, 0 });
        for (int[] element : elements) {
            drawSquare(g, element[0] * squareWidth(), boardTop + element[0] * squareHeight());
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

    @Override
    public void update(int[][] coordinates) {
        currentElement = coordinates;
        repaint();
    }

    @Override
    public void update(HashSet<int[]> elements) {
        this.elements = elements;
        repaint();
    }
}
