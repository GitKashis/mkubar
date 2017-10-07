package ru.job4j.collections;

import java.util.Iterator;

/**
 * Итератор для двухмерного массива.
 * Created by Kubar on 07.10.2017.
 */
class ArrayIterator implements Iterator {
    // исходный массив
    private final int[][] values;
    // строка
    private int position=0;
    // столбец
    private int index=1;

    ArrayIterator(int[][] values) {
        this.values = values;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        int arrLengh = values.length;
        return (position != arrLengh);
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Object next() {
        int subArrayLength = values[position].length;
        int arrLengh = values.length;
        Object result;

        // Сначала выводим значение, потом только переставляем курсор.
        result = values[position][index - 1];

        if (index < subArrayLength) {
            index++;
        }
        // "возврат" каретки, переход на новую строку.
        else if (position < arrLengh) {
            index = 1;
            position++;
        }
        return result;
    }
}
