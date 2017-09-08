package ru.job4j.tracker;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    public Item addComment(Item commentItem, String comment) {
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

        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(newItem.getId())) {
                this.items[i] = newItem;
            }
            break;
        }
    }

    /**
     * Метод создает новый массив на 1 элемент меньше,
     * находит элемент.
     * копирует в новый массив все элементы кроме найденного с индексом i.
     *
     * @param delItem - удаляемый элемент.
     */
    public void delete(Item delItem) {
        //новый массив меньше на 1.
        //находим индекс удаляемого элемента.
        int index = findIndex(delItem);

        if (index >= 0 && index < items.length)
        {
            Item[] copy = new Item[items.length-1];
            System.arraycopy(items, 0, copy, 0, index);
            System.arraycopy(items, index+1, copy, index, items.length-index-1);
            items = copy;
            position--;
        }
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
     *
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
    protected String createTime (){
        // Для получения текущего системного времени достаточно выполнить:
        long curTime = System.currentTimeMillis();
        // Хотите строку в формате, удобном Вам?
        return new SimpleDateFormat("dd.MM.yyyy").format(curTime);
    }

    /**
     * Метод возвращает копию массива this.items без null элементов.
     *
     * @return Item[]
     */
    public Item[] getAll() {
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

    //вспомогательный метод, возвращает индекс i элемента Item в массиве items[].
    protected int findIndex(Item item) {
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
