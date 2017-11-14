package ru.job4j.sorting;

import java.util.*;
/**
 * Тестовое задание на сортировку коллекций.
 * Дана структура данных, которую нужно дополнить и отсортировать по заданным шаблонам.
 * Чтобы была возможность переопределить методы equals, hashCode, toString
 * сделаем класс-обёртку ArrayLine для строки исходного массива.
 */
public class SortingSet {
    /**
     * Для удобства работы конвертируем массив строк в set.
     *
     * @param source - исходный массив
     * @return список записей типа ArrayLine без разделителей.
     */
    public Set<ArrayLine> convertAndAddToSet(String[] source) {
        Set<ArrayLine> out = new HashSet<>();

        for (String aSource : source) {
            ArrayLine str = new ArrayLine(aSource.split("/"));
            out.add(str);

            /*
             * Из подученного массива выделяем подстроку,
             * отсекаем хвостовой элемент и добавляем оставшуюся часть в список.
             * Уменьшаем и добавляем столько раз, сколько элементов в массиве.
             */
            for(int i = 0; i < str.length(); i++) {
                ArrayLine subLine = new ArrayLine(Arrays.copyOfRange(str.toArray(), 0, str.toArray().length - i));
                if ((str.toArray().length > 1)) {
                    out.add(subLine);
                }
            }


        }
        return out;
    }
}
