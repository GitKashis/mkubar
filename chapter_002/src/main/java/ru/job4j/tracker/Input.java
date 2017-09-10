package ru.job4j.tracker;

/**
 * Интерфейс методов для консольного ввода данных.
 * Содержит методы печати и диалога с пользователем.
 * Created by Kubar on 06.09.2017.
 */
interface Input {

    String ask(String question);

//    String toString(Item item);

    void print(Object[] objects);
}
