package ru.job4j.collections;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Создать итератор возвращающий только простые числа.
 * Итератор должен принимать массив произвольных чисел.
 *
 * Created by Kubar on 07.10.2017.
 */
class PrimeIterator implements Iterator {
    // исходный массив
    private final int[] values;
    // индекс
    private int position = 0;

    PrimeIterator(int[] values) {
        this.values = values;
    }

    /**
     * Возвращает true, только если в массиве есть простые справа от указателя.
     *
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        return isContain(position) ;
    }

    /**
     * Возвращает только простые числа.
     * Если простых чисел в массиве нет, то выкидывает ошибку NoSuchElementException.
     *
     * @return prime object.
     */
    @Override
    public Object next() {
        // если далее не обнаружено простых, то генерируем ошибку.
        if(!isContain(position))
            throw new NoSuchElementException();
        // иначе возвращаем простое и идем дальше.
        return values[position++];
    }

    /**
     * Вспомогательный метод, проверяет есть ли
     * в интервале (position, length) простые числа
     *
     * @param start - левая граница интервала.
     * @return true, если числа есть.
     */
    private boolean isContain(int start){
        boolean result = false;

        while (start < values.length){
            BigInteger bigInteger = BigInteger.valueOf(values[this.position]);

            if (bigInteger.isProbablePrime((int) Math.log(values[this.position]))){
                result = true;
                break;
            }
            start++;
            this.position++;
        }
        return result;
    }
}
