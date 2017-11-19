package ru.job4j.simplearray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Контейнер simplearray<T> на базе массива objects
 * Created by Kubar on 08.10.2017.
 */
@SuppressWarnings("unchecked")
public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int index = 0;
    private int itr = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Добавление элемента в конец массива.
     * @param value - добавляемое значение типа T.
     */
    public void add(T value) {
        this.objects[index++] = value;
    }

    /**
     * Удаление элемента из массива со сдвигом элементов,
     * Уменьшение длины массива на 1.
     * @param remIndex  - позиция элемента в массиве для удаления.
     */
    public void delete(int remIndex) {
        if (remIndex > this.objects.length)
            throw new IndexOutOfBoundsException();

        Object[] trimmedArray = new Object[this.objects.length - 1];
        // копирование со сдвигом.
        System.arraycopy(this.objects, remIndex + 1, trimmedArray, remIndex, this.objects.length - 1 - remIndex);
        this.objects = trimmedArray;
    }

    /**
     * Перезапись значения по указанному индексу.
     * @param updIndex - индекс.
     * @param value - значение.
     */
    public void update(int updIndex, T value) {
        if (updIndex > this.objects.length)
            throw new IndexOutOfBoundsException();

        this.objects[updIndex] = value;
    }

    /**
     * Возвращает из массива объект типа T по указанной позиции.
     * @param position - индекс.
     * @return T.
     */
    public T get(int position) {
        if (position > this.objects.length)
            throw new IndexOutOfBoundsException();

        return (T) this.objects[position];
    }

    /**
     * Get index of specified element.
     * @param elem - element which index you need.
     * @return int.
     */
    public int getIndex(T elem) {
        for (Object item : objects) {
            if (elem.equals(item)) {
                return Arrays.asList(objects).indexOf(elem);
            }
        }
        return -1;
    }

    /**
     * Iterator for simplearray.
     * @return Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        Object[] data = this.objects;
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return data.length > itr;
            }

            @Override
            public T next() {
                if (itr > data.length)
                    throw new NoSuchElementException();

                return (T) data[itr++];
            }
        };
    }
}
