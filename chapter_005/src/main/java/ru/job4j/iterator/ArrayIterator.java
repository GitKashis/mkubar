package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор для двухмерного массива.
 * Created by Kubar on 07.10.2017.
 */
class ArrayIterator implements Iterator {
    // исходный массив
    private final int[][] values;
    // строка
    private int position = 0;
    // столбец
    private int index = 0;

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
        return (position < values.length);
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Object next() {
        if (position == values.length) {
            throw new NoSuchElementException("No elements more");
        }

        Object result = values[position][index++];

        if (index == values[position].length) {
            index = 0;
            position++;
        }
        return result;
    }
}
