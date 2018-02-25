package ru.job4j.thread.search;

/*
 * Class for counting finished threads.
 */
public class FinishedThreadsCounter {
    /**
     * Threads count.
     */
    private volatile int threadsCount = 0;

    /**
     * Set count of threads.
     * @param threadsCount  - count of threads.
     */
    public void setThreadsCount(int threadsCount) {
        this.threadsCount = threadsCount;
    }

    /**
     * Down count if this thread was finished.
     */
    public synchronized void downCount() {
        threadsCount -= 1;
    }

    /**
     * Retrurn count of running threads.
     * @return int.
     */
    public int getThreadsCount() {
        return this.threadsCount;
    }
}
