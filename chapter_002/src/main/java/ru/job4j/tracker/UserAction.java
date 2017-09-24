package ru.job4j.tracker;

/**
 *
 * Created by Kubar on 12.09.2017.
 */
interface UserAction {
    // Персональный идентификатор класса,
    // соответствующий расположению в массиве действий.
    int key();

    // То, что доолжен делать класс с хранилищем Tracker в соответствии с интерфейсом Input.
    void execute(Input input, Tracker tracker);

    // Вывод информации о назначении класса.
    String info();
}
