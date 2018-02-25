package ru.job4j.thread.lock;

public class SimpleBlock {

    /**
     * Field for check need block thread.
     */
    private boolean block = false;

    /**
     * Method for block treads.
     * @throws InterruptedException if interrupt
     */
    public synchronized void lock() throws InterruptedException {
        while (block) {
            wait();
        }
        block = true;
    }

    /**
     * Method for unlock treads.
     */
    public synchronized void unlock() {
        block = false;
        notify();
    }
}
