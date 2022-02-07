package Miscellaneous;

import Sprites.Paper;

public class Timer extends Thread {
    public static int seconds;
    private boolean running;

    public void isRunning(boolean isRunning) {
        running = isRunning;
    }

    public void startTimer() {
        isRunning(true);
        start();
    }

    public void stopTimer() {
        isRunning(false);
        try {
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (running) {
            if (Paper.paper != 1) {
                try {
                    Thread.sleep(1000);
                    seconds++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
