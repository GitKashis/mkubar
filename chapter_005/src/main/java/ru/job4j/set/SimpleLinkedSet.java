package ru.job4j.set;

import ru.job4j.list.MyLinkedList;

import java.util.Iterator;

public class SimpleLinkedSet<T> extends MyLinkedList<T> {

    public void add(T item) {
        // если такого элемента нет, добавляем
        if (!check(item)) {
            super.add(item);
        }
    }

    /**
     * Check duplicate items.
     *
     * @param item - value
     * @return is contain
     */
    private boolean check(T item) {
        Iterator it = super.iterator();

        while (it.hasNext()) {
            if (item.equals(it.next())) {
                return true;
            }
        }
        return false;
    }
}
