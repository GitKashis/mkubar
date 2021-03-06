package ru.job4j.sorting;

import java.util.*;

public class Expand {
    /**
     * Метод разбивает входящий список на подгруппы .
     * @param value список чисел на вход.
     * @return на выходе список из расширяющихся последовательно списков
     */
    public Set<List<Integer>> expand(List<Integer> value) {
        // список списков
        Set<List<Integer>> result = new HashSet<>();
        // создаем список, который будет накапливать элементы для нового списка.
        List<Integer> out = new ArrayList<>();

        for (Integer aValue : value) {
            // накапливаем элементы, начиная с первого.
            out.add(aValue);
            // формируем список для добавления
            List<Integer> subList = new ArrayList<>(out);
            // добавляем сформированный список
            result.add(subList);
        }
        return result;
    }
}
