package ru.job4j.thread.lock;

public class Counter {

    /**
     * Field object for lock if thread work.
     */
    private final SimpleBlock block = new SimpleBlock();

    /**
     * Field for increment.
     */
    private int count = 0;

    /**
     * Method inc field.
     * @throws InterruptedException if interrupt
     */
    public void increment() throws InterruptedException {
        block.lock();
        count++;
        block.unlock();
    }

    /**
     * Getter for count field.
     * @return count
     */
    public int getCount() {
        return count;
    }
}
