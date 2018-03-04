package ru.job4j.thread.threadpool;

import org.junit.Test;

public class ThreadPoolTest {
    /**
     * Test class.
     */
    @Test
    public void whenThen() throws InterruptedException {
        ThreadPool threadPool = new ThreadPool(4);
        threadPool.go();
        for (int i = 0; i < 10000; i++) {
            threadPool.add(new Work());
        }
    }
}