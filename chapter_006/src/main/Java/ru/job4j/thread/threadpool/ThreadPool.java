package ru.job4j.thread.threadpool;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

    /**
     * Massif Thread.
     */
    private final WorkTread[] pool;

    /**
     * List work for Threads.
     */
    private final LinkedBlockingQueue<Work> poolWork = new LinkedBlockingQueue<>();

    /**
     * Constructor.
     * @param length count Thread
     */
    public ThreadPool(final int length) {
        this.pool = new WorkTread[length];
        for (int i = 0; i < length; i++) {
            pool[i] = new WorkTread();
            pool[i].start();
        }
    }

    /**
     * Method add work for Thread.
     * @param work for Thread
     */
    public void add(Work work) throws InterruptedException {
        poolWork.put(work);
    }

    /**
     * Initialize Threads.
     */
    private class WorkTread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    poolWork.take().print();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}