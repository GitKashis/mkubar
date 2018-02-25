package ru.job4j.thread.lock;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleBlockTest {

    @Test
    public void whenThen() throws InterruptedException {
        Counter counter = new Counter();

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 100_000; j++) {
                    try {
                        counter.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
        Thread.sleep(3000);
        assertThat(counter.getCount(), is(1_000_000));
    }
}