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
    // внутренний «рабочий» массив объектов
    private Object[] objects;
    // переменная отвечает за текущее количество объектов, указывает на последний элемент в массиве.
    // инкрементируется после каждого добавления, декремент после удаления.
    // Фактически, не соответствует длине рабочего массива, т.к. после удаления элемента массив не «подрезается»,
    // и в хвосте находятся null-элементы.
    private int index = 0;

    /**
     *  Конструктор.
     * @param size - исходный размер массива
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Добавление элемента в конец массива.
     * @param value - добавляемое значение типа T.
     */
    public void add(T value) {
        // если заполнен, создаем новый большей размерности
        if (index >= this.objects.length) {
            Object[] expandArray = new Object[objects.length * 2];
            System.arraycopy(this.objects, 0, expandArray, 0, index);
            this.objects = expandArray;
        }

        this.objects[index++] = value;
    }

    /**
     * Удаление элемента из массива со сдвигом элементов,
     * Уменьшение длины массива на 1.
     * @param remIndex  - позиция элемента в массиве для удаления.
     */
    public void delete(int remIndex) {
        if (remIndex > this.index)
            throw new IndexOutOfBoundsException();

        // копирование со сдвигом.
        System.arraycopy(this.objects, remIndex + 1, this.objects, remIndex, this.index - 1 - remIndex);
        // меняем «полезное» количество элементов
        this.index--;
    }

    /**
     * Перезапись значения по указанному индексу.
     * @param updIndex - индекс.
     * @param value - значение.
     */
    public void update(int updIndex, T value) {
        if (updIndex > this.index)
            throw new IndexOutOfBoundsException();

        this.objects[updIndex] = value;
    }

    /**
     * Возвращает из массива объект типа T по указанной позиции.
     * @param position - индекс.
     * @return T.
     */
    public T get(int position) {
        if (position > this.index)
            throw new IndexOutOfBoundsException();

        return (T) this.objects[position];
    }

    /**
     * Get index of specified element.
     * @param elem - element which index you need.
     * @return int.
     */
    public int getIndex(T elem) {
        return Arrays.asList(objects).indexOf(elem);
    }

    /**
     * Iterator for simplearray.
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
                if (itr > count)
                    throw new NoSuchElementException();

                return (T) data[itr++];
            }
        };
    }
}
