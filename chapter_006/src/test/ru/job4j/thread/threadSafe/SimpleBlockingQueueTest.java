package ru.job4j.thread.threadSafe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleBlockingQueueTest {

    /**
     * Емкость очереди.
     */
    private int limit = 5;

    /**
     * Скорость работы потоков
     */
    private int speedProducer = 100;
    private int speedConsumer = 100;

    private SimpleBlockingQueue<Integer> queue;
    private ExecutorService executorService;

    /**
     * Класс-поставщик.
     */
    class Producer implements Runnable {
        private final SimpleBlockingQueue<Integer> queue;

        public Producer(SimpleBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            System.out.println(String.format("[%s]: run", Thread.currentThread().getName()));
            while (true) {
                try {
                    queue.offer(produce());
                    Thread.currentThread().sleep(speedProducer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * Генератор чисел
         */
        private Integer produce() {
            Integer i = new Random().nextInt(100);
            System.out.println(String.format("[%s]: produce %s", Thread.currentThread().getName(), i));
            return i;
        }
    }

    /**
     * Класс-получатель.
     */
    class Consumer implements Runnable {
        private final SimpleBlockingQueue<Integer> queue;

        public Consumer(SimpleBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            System.out.println(String.format("[%s]: run", Thread.currentThread().getName()));
            while (true) {
                try {
                    int i = this.consume();
                    System.out.println(String.format("[%s]: consume %s", Thread.currentThread().getName(), i));
                    Thread.currentThread().sleep(speedConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private int consume() throws InterruptedException {
            return queue.poll();
        }
    }

    @Before
    public void setUp() {
        queue = new SimpleBlockingQueue<>(limit);
        executorService = Executors.newFixedThreadPool(5);
    }

    /**
     * Тест 1 входящего и 1 исходящего потоков.
     */
    @Test
    public void testTwoThread() throws InterruptedException {
        new Thread(new Producer(queue), "Producer").start();
        new Thread(new Consumer(queue), "Consumer").start();
    }

    /**
     * Если входящих потоков больше, то они быстрее заполняют очередь.
     * Исходящий не успевает разбирать.
     */
    @Test
    public void WhenThreeProducerOneCustomer() {
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Producer(queue));
        }

        for (int i = 0; i < 1; i++) {
            executorService.submit(new Consumer(queue));
        }
    }

    /**
     * Если входящих потоков больше, то они быстрее заполняют очередь.
     * Исходящий не успевает разбирать.
     */
    @Test
    public void WhenOneProducerThreeCustomer() {
        for (int i = 0; i < 1; i++) {
            executorService.submit(new Producer(queue));
        }

        for (int i = 0; i < 3; i++) {
            executorService.submit(new Consumer(queue));
        }
    }

    @After
    public void disposeThreads() throws InterruptedException {
        Thread.sleep(1000);
        executorService.shutdown();
    }
}