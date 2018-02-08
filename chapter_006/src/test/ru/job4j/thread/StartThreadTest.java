package ru.job4j.thread;

import org.junit.Test;

/**
 * Тестирование совместной работы потоков и метода прерывания isInterrupt().
 */
public class StartThreadTest {

    /**
     * Если времени мало, таймер остановится быстрее, чем закончится подсчет символов.
     * @throws InterruptedException
     */
    @Test
    public void whenTimeIsOver() throws InterruptedException {
        StartThread start = new StartThread(10);
        start.init();
    }

    /**
     * Если времени достаточно, то подсчет символов завершится успешно.
     *  @throws InterruptedException
     */
    @Test
    public void whenTimeIsNotOver() throws InterruptedException {
        StartThread start = new StartThread(10000);
        start.init();
    }
}