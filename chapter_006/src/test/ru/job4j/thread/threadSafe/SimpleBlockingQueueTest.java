package ru.job4j.thread.threadSafe;

import org.junit.Test;

import java.util.Random;

public class SimpleBlockingQueueTest {

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
                    Thread.currentThread().sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

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
                    Thread.currentThread().sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private int consume() throws InterruptedException {
            return queue.pool();
        }
    }

    /**
     * Тест 1 входящего и 1 исходящего потоков.
     */
    @Test
    public void testTwoThread() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(5);

        Thread producer = new Thread(new Producer(queue), "Producer");
        Thread customer = new Thread(new Consumer(queue), "Consumer");

        producer.start();
        customer.start();

        producer.join();
        customer.join();
    }

    /**
     * Если входящих потоков больше, то они быстрее заполняют очередь.
     * Исходящий не успевает разбирать.
     */
    @Test
    public void WhenThreeProducerOneCustomer() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(5);

        Thread producer1 = new Thread(new Producer(queue), "Producer1");
        Thread producer2 = new Thread(new Producer(queue), "Producer2");
        Thread producer3 = new Thread(new Producer(queue), "Producer3");

        Thread customer = new Thread(new Consumer(queue), "Customer");

        producer1.start();
        producer2.start();
        producer3.start();
        customer.start();

        producer1.join();
        producer2.join();
        producer3.join();
        customer.join();
    }

    /**
     * Входящий поток один, не успевает быстро заполнить очередь.
     * Исходящим приходится ждать.
     */
    @Test
    public void WhenOneProducerThreeCustomer() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(5);

        Thread producer = new Thread(new Producer(queue), "Producer");

        Thread customer1 = new Thread(new Consumer(queue), "Customer1");
        Thread customer2 = new Thread(new Consumer(queue), "Customer2");
        Thread customer3 = new Thread(new Consumer(queue), "Customer3");

        producer.start();
        customer1.start();
        customer2.start();
        customer3.start();

        producer.join();
        customer1.join();
        customer2.join();
        customer3.join();
    }
}