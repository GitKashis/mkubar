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
    public void lock() {
        synchronized (this) {
            try {
                while (block) {
                    wait();
                }
                block = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method for unlock treads.
     */
    public void unlock() {
        synchronized (this) {
            block = false;
            notifyAll();
        }
    }
}
