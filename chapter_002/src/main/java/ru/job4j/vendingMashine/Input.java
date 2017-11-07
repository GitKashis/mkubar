package ru.job4j.vendingMashine;

/**
 * Интерфейс методов для консольного ввода данных.
 * Содержит методы печати и диалога с пользователем.
 * Created by Kubar on 06.09.2017.
 */
interface Input {

    String ask(String question);

    // перегруженный метод ask.
    int ask(String question, int[] range);

    void print(Object[] objects);
}
