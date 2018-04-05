package ru.job4j.tracker.item;

import java.util.Date;

public class Bug extends Item {
    /**
     * Constract.
     * @param name имя заявки.
     * @param description описание.
     */
    public Bug(String name, String description) {
        setName(name);
        setDescription(description);
        setDate(new Date(System.currentTimeMillis()));
    }
}