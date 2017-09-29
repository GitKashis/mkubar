package ru.job4j.tracker;

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
    private Item[] items = new Item[100];
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
    Item add(Item item) {
        item.setId(this.generateId());
        item.setCreate(createTime());
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
    void delete(Item delItem) {
        //новый массив меньше на 1.
        //находим индекс удаляемого элемента.
        int index = this.findIndex(delItem);

        if (index >= 0 && index < items.length) {

            Item[] copy = new Item[items.length - 1];
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
    Item findById(String id) {
        Item result = null;
        for (Item item : this.getAll()) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод ищет элемент по заданному имени.
     *
     * @param name - имя в заявке
     * @return item - элемент массива.
     */
    Item findByName(String name) {
        Item result = null;
        for (Item item : this.getAll()) {
            if (item != null && item.getName().equals(name)) {
                result = item;
                break;
            }
        }
        return result;
    }

    private String createTime() {
        // Для получения текущего системного времени достаточно выполнить:
        long curTime = System.currentTimeMillis();
        // Хотите строку в формате, удобном Вам?
        return new SimpleDateFormat("dd.MM.yyyy").format(curTime);
    }

    /**
     * Метод возвращает копию массива this.items без null элементов.
     *
     * @return Backe[]
     */
    Item[] getAll() {
        Item result[] = new Item[position];
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
    private int findIndex(Item item) {
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
