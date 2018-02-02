package ru.job4j.yandex;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class EventAction<E> implements EventCounter {
    public static final int STEP_SIZE = 10;
    public static final int SECOND_SIZE = 1000;
    public static final int MINUTE_SIZE = 60 * SECOND_SIZE;
    public static final int HOUR_SIZE = 60 * MINUTE_SIZE;
    public static final int DAY_SIZE = 24 * HOUR_SIZE;

    private Long initialTimestamp;
    private volatile NavigableMap<TimePeriod, E> map;

    public EventAction(Long initialTimestamp) {
        this.initialTimestamp = initialTimestamp;
        map = new TreeMap<>();
    }

    @Override
    public void eventPerformed() {
        long currentTime = System.currentTimeMillis();
        map.put(currentTime, null);
    }

    @Override
    public long getEventCount(TimePeriod period) {
        return map()
    }
}
