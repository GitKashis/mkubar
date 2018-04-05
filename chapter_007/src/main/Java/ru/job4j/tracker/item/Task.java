package ru.job4j.tracker.item;

import java.util.Date;

public class Task extends Item {
    /**
     * Constaract.
     * @param name имя
     * @param description описание
     */
    public Task(String name, String description) {
        setName(name);
        setDescription(description);
        setDate(new Date(System.currentTimeMillis()));
    }
}