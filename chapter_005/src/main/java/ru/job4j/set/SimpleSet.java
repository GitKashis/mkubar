package ru.job4j.set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<T> implements Iterable<T> {
    // начальный размер массива
    private final int INIT_SIZE = 2;

    private Object[] objects = new Object[INIT_SIZE];
    // количество элементов
    private int index = 0;

    /*
    * Добавляет новый элемент в список. При достижении размера внутреннего
    * массива происходит его увеличение в два раза.
    */
    public void add(T item) {
        // массив уже заполнен?
        this.expand();
        // если такого элемента нет, добавляем
        if (!check(item)) {
            objects[index++] = item;
        }
    }

    /**
     * Check duplicate items.
     *
     * @param item - value
     * @return is contain
     */
    private boolean check(T item) {
        for (Object object : this.objects) {
            if (item.equals(object)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return count of elements
     */
    public int size() {
        return this.index;
    }

    /**
     * To expand, if the array is filled.
     *
     */
    private void expand() {
        // увеличу в 2 раза, если достигли границ
        if (index == objects.length - 1) {
            this.objects = Arrays.copyOf(objects, objects.length * 2);
        }
    }

    /**
     * Iterator for simplearray.
     *
     * @return Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        //
        int count = this.index;
        Object[] data = this.objects;

        return new Iterator<T>() {
            private int itr = 0;

            @Override
            public boolean hasNext() {
                return count > itr;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException();

                return (T) data[itr++];
            }
        };
    }

    public int getLength() {
        return this.objects.length;
    }
}
