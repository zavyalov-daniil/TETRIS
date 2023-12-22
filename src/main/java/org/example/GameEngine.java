package org.example;

import java.util.Timer;
import java.util.TimerTask;

public class GameEngine {
    Timer timer;
    public GameEngine() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), AppConstants.DELAY, AppConstants.INTERVAL);
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            gameCycle();
        }

        private void gameCycle() {

        }
    }
}
