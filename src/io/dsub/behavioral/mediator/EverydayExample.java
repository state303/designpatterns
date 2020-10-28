package io.dsub.behavioral.mediator;

import java.util.Timer;
import java.util.TimerTask;

public class EverydayExample {
    private Timer timer;

    public EverydayExample(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 1000);
        timer.schedule(new RemindTaskWithoutBeep(), seconds * 2 * 1000);
    }

    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Time's up!");
            // toolkit.beep();
        }
    }

    class RemindTaskWithoutBeep extends TimerTask {
        public void run() {
            System.out.println("Now Time's really up!");
            timer.cancel();
        }
    }

    public static void main(String[] args) {
        System.out.println("About to schedule task.");
        EverydayExample example = new EverydayExample(3);
        System.out.println("Task scheduled.");
    }
}
