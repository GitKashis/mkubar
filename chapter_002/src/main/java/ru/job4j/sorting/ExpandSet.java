package ru.job4j.sorting;

import java.util.*;

public class ExpandSet {

    /**
     * Метод разбивает входящий список на подгруппы .
     *
     * @param source массив строк на вход.
     * @return на выходе дополненное множество списков строк.
     */
    public Set<List<String>> expand(String[] source) {

        // множество массивов
        Set<List<String>> out = new HashSet<>();
        for (String aString : source) {
            String[] deps = aString.split("/");

            ArrayList<String> sum = new ArrayList<>();

            for (String values : deps) {
                sum.add(values);
                List<String> subStr = new ArrayList<>(sum);
                out.add(subStr);
            }
        }

        return out;
    }

    /**
     * Сортировка по возрастанию
     *
     * @param source на входе несортированное множество списков строк.
     * @return на выходе сортированное множество массивов строк.
     */
    public Set<String[]> sortUp(Set<List<String>> source) {

        Set<String[]> result = new TreeSet<>(new CompUp());

        for (List<String> list : source) {
            result.add(list.toArray(new String[list.size()]));
        }
        return result;
    }

    /**
     * Сортировка по убыванию.
     *
     * @param source на входе несортированное множество списков строк.
     * @return на выходе сортированное множество массивов строк.
     */
    public Set<String[]> sortDwn(Set<List<String>> source) {

        Set<String[]> result = new TreeSet<>(new CompDwn());

        for (List<String> list : source) {
            result.add(list.toArray(new String[list.size()]));
        }
        return result;
    }

    /*
     * Класс-компаратор.
     */
    class CompUp implements Comparator<String[]> {

        @Override
        public int compare(String[] o1, String[] o2) {
            // первй элемент есть всегда
            int compareResult = o1[0].compareTo(o2[0]);

            for (int i = 1; i < Math.max(o1.length, o2.length); i++) {
                if (compareResult == 0) {
                    // первые равны, дальше проверить длину

                    if ((o1.length <= i) || (o2.length <= i)) compareResult = o1.length - o2.length;
                    else {
                        compareResult = o1[i].compareTo(o2[i]);
                    }
                }
            }
            return compareResult;
        }
    }

    class CompDwn implements Comparator<String[]> {

        @Override
        public int compare(String[] o1, String[] o2) {
            // первй элемент есть всегда
            int compareResult = -o1[0].compareTo(o2[0]);

            for (int i = 1; i < Math.max(o1.length, o2.length); i++) {
                if (compareResult == 0) {
                    // первые равны, дальше проверить длину

                    if ((o1.length <= i) || (o2.length <= i)) compareResult = (o1.length - o2.length);
                    else {
                        compareResult = -o1[i].compareTo(o2[i]);
                    }
                }
            }
            return compareResult;
        }
    }
}
