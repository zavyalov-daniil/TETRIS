package org.example;

import org.example.command.Command;
import org.example.command.factory.CommandFactory;
import org.example.model.Tetromino;
import org.example.model.factory.TetrominoFactory;
import org.example.model.factory.TetrominoFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Component
public class GameEngine {
    Timer timer;
    CommandFactory commandFactory;
    TetrominoFactory tetrominoFactory;

    public GameEngine(CommandFactory commandFactory) {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), AppConstants.DELAY, AppConstants.INTERVAL);
        this.commandFactory = commandFactory;
    }

    @Autowired
    @Lazy
    public void setTetrominoFactory(TetrominoFactory tetrominoFactory) {
        this.tetrominoFactory = tetrominoFactory;
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            gameCycle();
        }

        private void gameCycle() {
            Command command = commandFactory.getMoveCommand(tetrominoFactory.getCurrent(), 0, 1);
            command.execute();

        }
    }
}
