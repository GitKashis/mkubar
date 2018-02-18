package ru.job4j.thread;

import org.junit.Test;
import ru.job4j.thread.threadSafe.TimerThread;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тестирование програмного прерывания потока.
 */
public class TimeCounterTest {
    /**
     * Время, отведенное для подсчета.
     * Если не успели, прерываем.
     */
    private int time = 10;

    @Test
    public void whenTimeIsOutThenInterrupt() throws InterruptedException {
        TimerThread t1 = new TimerThread(10);
        assertThat(t1.startCount(), is(true));
    }
    @Test
    public void whenTimeIsNotOver() throws InterruptedException {
        TimerThread t1 = new TimerThread(1000);
        assertThat(t1.startCount(), is(false));
    }
}
