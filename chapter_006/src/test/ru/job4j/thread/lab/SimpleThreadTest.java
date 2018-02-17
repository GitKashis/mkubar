package ru.job4j.thread.lab;

import org.junit.Test;

/**
 * Тестирование совместной работы потоков в течение заданного времени.
 */
public class SimpleThreadTest {
    /**
     * в течение какого времени выполнять работу в потоке.
     */
    private int period1 = 500;
    private int period2 = 1000;
    private int period3 = 1500;

    /**
     * Тестирование одновременно-последовательной работы трех потоков с заданными параметрами.
     */
    @Test
    public void testThreeTreads() throws InterruptedException {
        Thread t1 = new Thread(new SimpleThread(period1), "t1");
        Thread t2 = new Thread(new SimpleThread(period2), "t2");
        Thread t3 = new Thread(new SimpleThread(period3), "t3");

        //запускаем третий поток
        t3.start();

        //стартуем первый поток только после 6-секундного ожидания третьего потока
        //(или когда он умрет/закончит выполнение)
        t3.join(6000);
        t1.start();

        //стартуем 2-й поток только после того, как 1 поток закончит свое выполнение
        t1.join();
        t2.start();

        //даем всем потокам возможность закончить выполнение перед тем, как программа (главный поток) закончит свое выполнение
        t1.join();
        t2.join();
        t3.join();

        System.out.println("Все потоки отработали, завершаем программу.");
    }
}