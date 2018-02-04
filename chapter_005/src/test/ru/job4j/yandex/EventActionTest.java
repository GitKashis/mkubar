package ru.job4j.yandex;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.job4j.yandex.TimePeriod.*;

/**
 * Класс для моделирования и тестирования учета событий за конечный промежуток времени.
 */
public class EventActionTest {

    private EventAction eventAction;

    @Before
    public void init(){
        eventAction = new EventAction();
    }

    @Test
    public void test1(){
        eventAction.eventPerformed();

        assertEquals(1, eventAction.getEventCount(LAST_SECOND));
        assertEquals(1, eventAction.getEventCount(LAST_MINUTE));
        assertEquals(1, eventAction.getEventCount(LAST_HOUR));
        assertEquals(1, eventAction.getEventCount(LAST_DAY));
    }
    @Test
    public void test2(){
        eventAction.eventPerformed();
        eventAction.eventPerformed();
        eventAction.eventPerformed();
        eventAction.eventPerformed();

        assertEquals(4, eventAction.getEventCount(LAST_SECOND));
        assertEquals(4, eventAction.getEventCount(LAST_MINUTE));
        assertEquals(4, eventAction.getEventCount(LAST_HOUR));
        assertEquals(4, eventAction.getEventCount(LAST_DAY));

        eventAction.eventPerformed();
        assertEquals(5, eventAction.getEventCount(LAST_SECOND));
        assertEquals(5, eventAction.getEventCount(LAST_MINUTE));
        assertEquals(5, eventAction.getEventCount(LAST_HOUR));
        assertEquals(5, eventAction.getEventCount(LAST_DAY));
    }

    @Test
    public void test3() throws InterruptedException {
        eventAction.eventPerformed();
        assertEquals(1, eventAction.getEventCount(LAST_SECOND));
        assertEquals(1, eventAction.getEventCount(LAST_MINUTE));

        // sleep for 1 second
        Thread.sleep(1000);
        eventAction.eventPerformed();
        assertEquals(1, eventAction.getEventCount(LAST_SECOND));
        assertEquals(2, eventAction.getEventCount(LAST_MINUTE));

        // sleep for 1 second
        Thread.sleep(1000);
        eventAction.eventPerformed();
        eventAction.eventPerformed();
        eventAction.eventPerformed();

        assertEquals(3, eventAction.getEventCount(LAST_SECOND));
        assertEquals(5, eventAction.getEventCount(LAST_MINUTE));
    }
}