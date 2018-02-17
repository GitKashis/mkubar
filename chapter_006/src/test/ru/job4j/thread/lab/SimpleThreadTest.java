package ru.job4j.thread.lab;

import org.junit.Test;

/**
 * Тестирование совместной работы потоков в течение заданного времени.
 */
public class SimpleThreadTest {

    /**
     * в течение какого времени выполнять работу в потоке.
     */
    private int value = 5;

    @Test
    public void testThreeTreads() throws InterruptedException {
        Thread t1 = new Thread(new SimpleThread(value), "t1");
        Thread t2 = new Thread(new SimpleThread(value), "t2");
        Thread t3 = new Thread(new SimpleThread(value), "t3");

        t1.start();

        //стартуем второй поток только после 2-секундного ожидания первого потока (или когда он умрет/закончит выполнение)
        t1.join(2000);
        t2.start();

        //стартуем 3-й поток только после того, как 1 поток закончит свое выполнение
        t1.join();
        t3.start();

        //даем всем потокам возможность закончить выполнение перед тем, как программа (главный поток) закончит свое выполнение
        t1.join();
        t2.join();
        t3.join();

        System.out.println("Все потоки отработали, завершаем программу.");
    }
}