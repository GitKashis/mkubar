package ru.job4j.thread.lock;

public class SimpleBlock {

    /**
     * Field for check need block thread.
     */
    private boolean block = false;

    /**
     * Текущий поток, одиаковый для метода lock и unlock.
     */
    private Thread owner;
    /**
     * Method for block treads.
     * @throws InterruptedException if interrupt
     */
    public synchronized void lock() {
            try {
                while (block) {
                    wait();
                }
                block = true;
                owner = Thread.currentThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    /**
     * Method for unlock treads.
     */
    public synchronized void unlock() {
            if (Thread.currentThread() == owner) {
                block = false;
                notifyAll();
            }
    }
}
