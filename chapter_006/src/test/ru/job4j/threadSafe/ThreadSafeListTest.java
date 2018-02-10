package ru.job4j.threadSafe;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ThreadSafeListTest {

    @Test
    public void whenAddElementsThenItAddedToCollection() throws InterruptedException {
        ThreadSafeList<Integer> threadSafe = new ThreadSafeList<>();

        Thread t1 = new Thread(() -> {
            threadSafe.add(0);
            threadSafe.add(1);
            threadSafe.add(2);
            for (int val : threadSafe) {
                System.out.println("thread-1 : " + val);
            }
            threadSafe.add(3);
            threadSafe.add(4);
            threadSafe.add(5);
            threadSafe.get(2);
        });

        Thread t2 = new Thread(() -> {
            threadSafe.add(6);
            threadSafe.add(7);

            for (int val : threadSafe) {
                System.out.println("thread-2 : " + val);
            }

            threadSafe.add(8);
            threadSafe.remove(0);
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertThat(threadSafe.size(), is(8));
    }
}