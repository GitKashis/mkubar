package ru.job4j.yandex;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.job4j.yandex.TimePeriod.*;

public class EventActionThreadTest {
    
    private EventAction eventAction;

    @Before
    public void init(){
        eventAction = new EventAction();
    }
    /***
     * Test case 1:
     *
     *  In this case 2 threads generated events
     *  First thread generate 10'000 events
     *  Second thread generate 100'000 events
     *
     *  Expected result: getEventCount(LAST_SECOND) return 110'000
     */
    @Test
    public void test1() throws InterruptedException {

        Thread th1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                eventAction.eventPerformed();
            }
        });


        Thread th2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                eventAction.eventPerformed();
            }
        });

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        assertEquals(110000, eventAction.getEventCount(LAST_SECOND));
    }

    /***
     * Test case 2:
     *
     *  In this case 2 threads generated events
     *  First thread generate 10'000 events and sleep for 1 second
     *  Second thread generate 100'000 events and sleep for 1 second
     *
     *  Expected result: getEventCount(LAST_SECOND) return 110'000
     */
    @Test
    public void test2() throws InterruptedException {

        Thread th1 = new Thread(() -> {
            try {
                for (int i = 0; i < 10000; i++) {
                    eventAction.eventPerformed();
                }

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread th2 = new Thread(() -> {
            try {
                for (int i = 0; i < 100000; i++) {
                    eventAction.eventPerformed();
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        assertEquals(0, eventAction.getEventCount(LAST_SECOND));
        assertEquals(110000, eventAction.getEventCount(LAST_MINUTE));
    }
}
