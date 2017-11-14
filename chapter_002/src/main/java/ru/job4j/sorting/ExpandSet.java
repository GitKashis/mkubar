package ru.job4j.sorting;

import java.util.*;

public class ExpandSet {


    /*
  Классы-компараторы.
 */
    class Comp implements Comparator<List<String>> {

        @Override
        public int compare(List<String> o1, List<String> o2) {
            if (o1.size() < o2.size()) return -1;
                else if (o1.size() == o2.size()) return 0;
                    else return 1;
        }
    }


    /**
     * Метод разбивает входящий список на подгруппы .
     * @param  source список чисел на вход.
     * @return на выходе список из расширяющихся последовательно списков
     */
    public Set<String[]> expand(String[] source) {

        // множество массивов
        Set<String[]> result = new HashSet<>();
        int i=0;
        for (String aString : source) {
            System.out.println(i++);
            String[] deps = aString.split("/");

            List<String> sum = new ArrayList();

            for (String values : deps) {
                sum.add(values);
                List<String> subStr = new ArrayList<>(sum);
                result.add(subStr.toArray(new String[subStr.size()]));
            }
        }
        return result;
    }
}
