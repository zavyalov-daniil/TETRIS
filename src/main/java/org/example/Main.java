package org.example;

import org.example.view.BoardView;
import org.example.view.TetrisView;
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
        TetrisView tetrisView = context.getBean(TetrisView.class);
        BoardView boardView = context.getBean(BoardView.class);
        tetrisView.add(boardView);
        tetrisView.repaint();

        EventQueue.invokeLater(() -> {
            tetrisView.setVisible(true);
        });
        GameEngine engine = context.getBean(GameEngine.class);
    }
}