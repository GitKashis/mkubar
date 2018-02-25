package ru.job4j.thread.threadpool;

public class Work {

    /**
     * Test Thread pool.
     */
    public void print() {
        System.out.println(String.format("Thread name is: %s", Thread.currentThread().getId()));
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
