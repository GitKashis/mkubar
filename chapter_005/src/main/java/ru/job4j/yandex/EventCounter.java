package ru.job4j.yandex;

public interface EventCounter {
    void eventPerformed();
    long getEventCount(TimePeriod period);
}
