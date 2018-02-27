package ru.job4j.thread.threadSafe;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

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
    }

    /**
     * Тест 1 входящего и 1 исходящего потоков.
     */
    @Test
    public void testTwoThread() throws InterruptedException {

        new Thread(new Producer(queue), "Producer").start();
        new Thread(new Consumer(queue), "Consumer").start();

        Thread.sleep(2000);
    }

    /**
     * Если входящих потоков больше, то они быстрее заполняют очередь.
     * Исходящий не успевает разбирать.
     */
    @Test
    public void WhenThreeProducerOneCustomer() throws InterruptedException {

        for (int i = 0; i < 3; i++) {
            new Thread(new Producer(queue), "Producer" + i).start();
        }

        for (int i = 0; i < 1; i++) {
            new Thread(new Consumer(queue), "Consumer" + i).start();
        }

        Thread.sleep(2000);
    }

    /**
     * Если входящих потоков больше, то они быстрее заполняют очередь.
     * Исходящий не успевает разбирать.
     */
    @Test
    public void WhenOneProducerThreeCustomer() throws InterruptedException {
        for (int i = 0; i < 1; i++) {
            new Thread(new Producer(queue), "Producer" + i).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(new Consumer(queue), "Consumer" + i).start();
        }

        Thread.sleep(2000);
    }

}