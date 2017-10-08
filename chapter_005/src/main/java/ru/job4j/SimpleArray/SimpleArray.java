package ru.job4j.SimpleArray;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Контейнер SimpleArray<T> на базе массива objects
 * Created by Kubar on 08.10.2017.
 */
@SuppressWarnings("unchecked")
public class SimpleArray<T> implements Iterable<T>{
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
    public void add(T value){
        this.objects[index++] = value;
    }

    /**
     * Удаление элемента из массива со сдвигом (без дыр) элементов,
     * Уменьшение длины массива на 1.
     * @param remIndex  - позиция элемента в массиве для удаления.
     */
    public void delete(int remIndex){
        // копирование со сдвигом.
        System.arraycopy(this.objects, remIndex + 1, this.objects, remIndex, this.objects.length - 1 - remIndex);

        // создаем массив меньшей длины, приводим к типу T.
        T[] newArr =(T[]) new Object[this.objects.length - 1];

        // копируем в новый массив.
        System.arraycopy(this.objects, 0, newArr, 0, this.objects.length - 1);
        this.objects = newArr;
    }

    /**
     * Перезапись значения по указанному индексу.
     * @param updIndex
     * @param value
     */
    public void update(int updIndex, T value){
        this.objects[updIndex] = value;
    }

    /**
     * Возвращает из массива объект типа T по указанной позиции.
     * @param position
     * @return T.
     */
    public T get(int position){
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
     * Iterator for SimpleArray.
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
                return (T) data[itr++];
            }
        };
    }
}
