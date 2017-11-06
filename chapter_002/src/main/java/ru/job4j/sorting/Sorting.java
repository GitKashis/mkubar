package ru.job4j.sorting;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Тестовое задание на сортировку коллекций.
 * Дана структура данных, которую нужно дополнить и отсортировать по заданным шаблонам/
 * Чтобы была возможность переопределить методы equals, hashCode, toString
 * преобразуем строки исходного массива в класс ArrayLine, содержащий в себе массив строк.
 */
public class Sorting {

    /**
     * Для удобства работы конвертируем массив строк в список.
     * @param source - исходный массив
     * @return список записей типа ArrayLine без разделителей.
     */
    public List<ArrayLine> convertToList(String[] source){
        List<ArrayLine> out = new ArrayList<>();

        for (String aSource : source) {
            ArrayLine arrayLine = new ArrayLine(aSource.split("/"));
            out.add(arrayLine);
        }
        return out;
    }

    public List<ArrayLine> checkAndAdd(List<ArrayLine> list){
        // во избежание ConcurrentModificationException
        // создаем копию листа, в которую будем дописывать недостающие записи.
        List<ArrayLine> out = new ArrayList<>(list);

        for (ArrayLine str : list) {
            // отсекаем хвостовой элемент, добавляем остаток в список.
            ArrayLine subLine = new ArrayLine(Arrays.copyOfRange(str.toArray(), 0, str.toArray().length - 1));
            if ((str.toArray().length > 1))
                out.add(subLine);
        }
        // после добавлений откуда-то появились дубликаты. Удалим их.
        return out.stream().distinct().collect(Collectors.toList());
}

    /**
     * Сортировка по возрастанию
     * .
     * @param list - на входе несортированный расширеный список записей.
     * @return на выходе тот же список, но уже сортированый.
     */
    public List<ArrayLine> sortUp(List<ArrayLine> list){
        //  задаем порядок сравнения.
        Comparator<ArrayLine> comp = new firstComp()
                .thenComparing(new twoComp())
                .thenComparing(new threeComp());

        list.sort(comp);

        return list;
    }

    /**
     * Сортировка по убывыанию.
     * .
     * @param list - на входе несортированный расширеный список записей.
     * @return на выходе тот же список, но уже сортированый.
     */
    public List<ArrayLine> sortDwn(List<ArrayLine> list){
        //  задаем порядок сравнения.
        Comparator<ArrayLine> comp = new firstComp().reversed()
                // на оставшиеся компараторы метод reversed не подействовал,
                // поэтому созданы компараторы, аналогичные прежним, но с измененным порядком сравнения.
                .thenComparing(new twoDwnComp())
                .thenComparing(new threeDwnComp());

        list.sort(comp);

        return list;
    }

    /*
      Классы-компараторы.
     */
    class firstComp implements Comparator<ArrayLine>{
        public int compare(ArrayLine o1, ArrayLine o2) {
            return o1.toArray()[0].compareTo( o2.toArray()[0]);
        }
    }

    class twoComp implements Comparator<ArrayLine>{
        public int compare(ArrayLine o1, ArrayLine o2) {
            if (o1.length() == 1) return -1;
                else if (o2.length() == 1) return 1;
                    else return (o1.toArray()[1].compareTo(o2.toArray()[1]));
        }
    }

    class threeComp implements Comparator<ArrayLine>{
        public int compare(ArrayLine o1, ArrayLine o2) {
            if (o1.length() == 2) return -1;
                else if (o2.length() == 2) return 1;
                    else return (o1.toArray()[2].compareTo(o2.toArray()[2]));
        }
    }

    class twoDwnComp implements Comparator<ArrayLine> {
        public int compare(ArrayLine o1, ArrayLine o2) {
            if (o1.length() == 1) return -1;
            else if (o2.length() == 1) return 1;
            // изменен порядок сравнения на o2 - o1
            else return (o2.toArray()[1].compareTo(o1.toArray()[1]));
        }
    }

    class threeDwnComp implements Comparator<ArrayLine>{
        public int compare(ArrayLine o1, ArrayLine o2) {
            if (o1.length() == 2) return -1;
            else if (o2.length() == 2) return 1;
            // изменен порядок сравнения на o2 - o1
            else return (o2.toArray()[2].compareTo(o1.toArray()[2]));
        }
    }
}
