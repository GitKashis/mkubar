package ru.job4j.tracker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
    private List<Item> items = new ArrayList<>();
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
        this.items.add(item);
        return item;
    }

    /**
     * Метод добавляет комментарий к указанному элементу массива.
     *
     * @param commentItem - заявка, для которой нужно добавить коментарий.
     * @param comment     - коментарий.
     * @return item.
     */
    Item addComment(Item commentItem, String comment) {
               //находим в массиве заявку, для которой надо добавить коментарий.
                       Item item = findById(commentItem.getId());
        if (item != null) {
            item.setComment(comment);
                   }
                return item;
            }

   /**
    * Метод перезаписывает элемент с соответствующим Id.
 *
     * @param newItem - измененный элемент.
     */
   void update(Item newItem) {
       for(int i = 0; i < items.size(); i++){
           if (items.get(i).getId().equals(newItem.getId()))
           {
               items.set(i, newItem);
               break;
           }
       }
   }


    /**
     * Метод создает новый массив на 1 элемент меньше,
     * находит элемент.
     * копирует в новый массив все элементы кроме найденного с индексом i.
     *
     * @param delItem - удаляемый элемент.
     */
    void delete(Item delItem) {

        items.remove(delItem);
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
    List<Item> getAll() {
        for(Item item : items){
            items.remove(null);
            }
        return items;
    }

    // вспомогательный метод для генерации уникального ключа Id.
    private String generateId() {
        return String.valueOf(rn.nextInt(100));
    }
}
