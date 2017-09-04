package ru.job4j.tracker;

import java.util.Random;

/**
 * Метод хранит массив заявок items, реализует операции CRUD для объектов типа Item.
 *
 * @author Mikhail Kubar
 * @version 1.0
 * @since 04.09.17
 */
public class Tracker {
    //выделяем память для массива заявок Item на 100 элементов.
    private Item[] items = new Item[100];
    //индекс массива Items[].
    private int position = 0;
    //случайное число для присвоения Id.
    private static final Random rn = new Random();

    /**
     * Метод присваивает новой заявке рандомный Id и добавляет в конец массива items.
     *
     * @param item - новая заявка.
     * @return Item item.
     */
    public Item add(Item item) {
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
    public Item add(Item commentItem, String comment) {
        //находим в массиве заявку, для которой надо добавить коментарий.
        Item item = findById(commentItem.getId());
        if (item != null) {
            item.setComment(comment);
        }
        return item;
    }

    /**
     * Метод перезаписывает элемент с соответствующим Id
     *
     * @param newItem - измененный элемент.
     */
    public void update(Item newItem) {
//        // получаем ссылку на искомый элемент массива,
//        // перекидываем эту ссылку на другой объект.
//        Item item = findById(newItem.getId());
//        item = newItem;

        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(newItem.getId())) {
                this.items[i] = newItem;
            }
            break;
        }
    }

    /**
     * Метод создает новый массив на 1 элемент меньше,
     * находит элемент с соответствующим Id,
     * копирует в новый массив все элементы кроме найденного с индексом i.
     *
     * @param delItem - удаляемый элемент.
     */
    public void delete(Item delItem) {
        int i;
        Item[] result = new Item[this.items.length - 1];
        for (i = 0; i < this.items.length; i++) {
            if (this.items[i].getId().equals(delItem.getId()))
                break;
        }
        // индекс найден. Копируем левую часть.
        System.arraycopy(items, 0, result, 0, i - 1);
        //копируем оставшуюся правую часть.
        System.arraycopy(items, i + 1, result, i, items.length - i - 1);
        //именьшаем текущую позицию в массиве
        position--;
    }

    /**
     * Метод ищет в массиве запись с соответствующим Id.
     *
     * @param id уникальный ключ для элементов массива.
     * @return item - элемент массива.
     */
    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id))
                result = item;
            break;
        }
        return result;
    }

    /**
     * Метод ищет элемент по заданному имени.
     * @param name - имя в заявке
     * @return item - элемент массива.
     */
    protected Item findByName(String name) {
        Item result = null;

        for (Item item : items) {
            if (item != null && item.getName().equals(name)) {
                result = item;
            }
            break;
        }
        return result;
    }


    /**
     * Метод возвращает копию массива this.items без null элементов.
     * @return Item[]
     */
    public Item[] getAll() {
        Item result[] = new Item[position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    // вспомогательный метод для генерации уникального ключа Id.
    private String generateId() {
        return String.valueOf(rn.nextInt());
    }
}
