package ru.job4j.VendingMashine;


/**
 *
 * Created by Kubar on 12.09.2017.
 */
interface UserAction {
    // Персональный идентификатор класса,
    // соответствующий расположению в массиве действий.
    int key();

    // То, что доолжен делать класс с хранилищем Vending в соответствии с интерфейсом Input.
    void execute(Input input, Vending vending);

    // Вывод информации о назначении класса.
    String info();
}
