package org.example;

import org.example.view.Board;
import org.example.view.Tetris;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.awt.*;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        Tetris tetris = context.getBean(Tetris.class);
        Board board = context.getBean(Board.class);
        tetris.add(board);
        tetris.repaint();

        EventQueue.invokeLater(() -> {
            tetris.setVisible(true);
        });
        GameEngine engine = new GameEngine();
    }
}