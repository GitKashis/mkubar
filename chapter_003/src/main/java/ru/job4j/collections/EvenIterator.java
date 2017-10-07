package ru.job4j.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Создать итератор возвращающий только четные цифры.
 * Итератор должен принимать список произвольных чисел.
 *
 * Created by Kubar on 07.10.2017.
 */
class EvenIterator implements Iterator {
    // исходный массив
    private final int[] values;
    // индекс
    private int position = 0;

    EvenIterator(int[] values) {
        this.values = values;
    }

    /**
     * Возвращает true, только если в массиве есть четные справа от указателя.
     *
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        return isContain(position) ;
    }

    /**
     * Возвращает только четные числа.
     * Если четных чисел в массиве нет, то выкидывает ошибку NoSuchElementException.
     *
     * @return even object.
     */
    @Override
    public Object next() {
        // если далее не обнаружено четных, то генерируем ошибку.
        if(!isContain(position))
            throw new NoSuchElementException();
        // иначе возвращаем четное и идем дальше.
        return values[position++];
    }

    /**
     * Вспомогательный метод, проверяет есть ли
     * в интервале (position, length) четные числа
     *
     * @param start - левая граница интервала.
     * @return true, если числа есть.
     */
    private boolean isContain(int start){
        boolean result = false;

         while (start < values.length){
            if (values[this.position] % 2 == 0){
                result = true;
                break;
            }
            start++;
            this.position++;
        }
        return result;
    }
}
