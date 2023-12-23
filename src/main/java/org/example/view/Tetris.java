package org.example.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class Tetris extends JFrame {

    private JLabel statusBar;

    public Tetris() {
        statusBar = new JLabel(" 0");
        add(statusBar, BorderLayout.SOUTH);
        //board.repaint();

        setTitle("Tetris lab");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public JLabel getStatusBar() {
        return statusBar;
    }
}
