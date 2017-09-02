package ru.job4j.models;

/**
 * Класс WorkPlan позволяет записывать и считывать данные о проделанной работе.
 */
public class WorkPlan {

    /**
     * @value count - количество выполненной работы.
     */
    private int count;

    /**
     * @value record - запись в журнале.
     */
    private String record;
    //геттер record.
    public String getRecord() {
        return record;
    }
    //сеттер recors.
    public void setRecord(String record) {
        this.record = record;
    }
    //геттер count.
    public int getCount() {
        return count;
    }
    //сеттер count.
    public void setCount(int count) {
        this.count = count;
    }
}
