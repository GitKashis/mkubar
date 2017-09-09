package ru.job4j.tracker;

/**
 * Интерфейс методов для консольного ввода данных.
 * Содержит методы печати и диалога с пользователем.
 * Created by Kubar on 06.09.2017.
 */
public interface Input {

    String ask(String question);

    void print(String[] menu);

    void print(Item[] items);

    void print(Item item);
}
