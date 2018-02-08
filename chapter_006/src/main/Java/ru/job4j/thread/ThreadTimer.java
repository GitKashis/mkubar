package ru.job4j.thread;

public class ThreadTimer implements Runnable {
    private int time;

    public ThreadTimer(int time) {
        this.time = time;
    }

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.currentThread().interrupt();
    }
}
