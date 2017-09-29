package ru.job4j.VendingMashine;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * Метод хранит массив заявок items, реализует операции CRUD для объектов типа Backe.
 *
 * @author Mikhail Kubar
 * @version 1.0
 * @since 04.09.17
 */
class Tracker {
    //выделяем память для массива заявок Backe на 100 элементов.
    private Backe[] items = new Backe[100];
    //индекс массива Items[].
    private int position = 0;
    //случайное число для присвоения Id.
    private static final Random rn = new Random();

    /**
     * Метод присваивает новой заявке рандомный Id и добавляет в конец массива items.
     *
     * @param item - новая заявка.
     * @return Backe item.
     */
    ru.job4j.tracker.Item add(ru.job4j.tracker.Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * Метод добавляет комментарий к указанному элементу массива.
     *
     * @param commentItem - заявка, для которой нужно добавить коментарий.
     * @param comment     - коментарий.
     * @return item.
     */



    /**
     * Метод создает новый массив на 1 элемент меньше,
     * находит элемент.
     * копирует в новый массив все элементы кроме найденного с индексом i.
     *
     * @param delItem - удаляемый элемент.
     */
    void delete(ru.job4j.tracker.Item delItem) {
        //новый массив меньше на 1.
        //находим индекс удаляемого элемента.
        int index = this.findIndex(delItem);

        if (index >= 0 && index < items.length) {

            ru.job4j.tracker.Item[] copy = new ru.job4j.tracker.Item[items.length - 1];
            System.arraycopy(items, 0, copy, 0, index);
            System.arraycopy(items, index + 1, copy, index, items.length - index - 1);
            this.items = copy;
            position--;
        }
    }

    /**
     * Метод ищет в массиве запись с соответствующим Id.
     *
     * @param id уникальный ключ для элементов массива.
     * @return item - элемент массива.
     */
    ru.job4j.tracker.Item findById(String id) {
        ru.job4j.tracker.Item result = null;
        for (ru.job4j.tracker.Item item : this.getAll()) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод возвращает копию массива this.items без null элементов.
     *
     * @return Backe[]
     */
    ru.job4j.tracker.Item[] getAll() {
        ru.job4j.tracker.Item result[] = new ru.job4j.tracker.Item[position];
        for (int i = 0; i != this.position; i++) {
            if (items[i] != null)
                result[i] = this.items[i];
        }
        return result;
    }

    // вспомогательный метод для генерации уникального ключа Id.
    private String generateId() {
        return String.valueOf(rn.nextInt(100));
    }

    //вспомогательный метод, возвращает индекс i элемента Backe в массиве items[].
    private int findIndex(ru.job4j.tracker.Item item) {
        int index = -1;
        
        for (int i = 0; i < this.items.length; i++) {
            if (items[i] != null && this.items[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

}
