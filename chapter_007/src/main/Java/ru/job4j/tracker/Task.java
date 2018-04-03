package ru.job4j.tracker;

public class Task extends Item {
    /**
     * Constaract.
     * @param name имя
     * @param description описание
     */
    public Task(String name, String description) {
        setName(name);
        setDescription(description);
        setData();
    }
}