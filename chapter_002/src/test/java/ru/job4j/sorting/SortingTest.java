package ru.job4j.sorting;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тестирование добавления данных в структуру,
 * сортировка по заданному шаблону.
 */
public class SortingTest {
    // инициализация
    Sorting sorting = new Sorting();
    // исходный массив
    String[] source = new String[]{
            "K1/SK1",
            "K1/SK2",
            "K1/SK1/SSK1",
            "K1/SK1/SSK2",
            "K2",
            "K2/SK1/SSK1",
            "K2/SK1/SSK2"
    };

    /**
     * Проверим добавление элементов. Было 7, стало 9.
     */
    @Test
    public void checkAndAdd() throws Exception {
        List<ArrayLine> result = sorting.checkAndAdd(sorting.convertToList(source));
        System.out.println("Проверка добавления элементов:");
        result.forEach(o -> System.out.println(o.toString()));

        assertThat(result.size(), is(9));
    }

    /**
     * Тестирование сортировки по возрастанию.
     */
    @Test
    public void sortUp() throws Exception {
        List<ArrayLine> result = sorting.sortUp(sorting.checkAndAdd(sorting.convertToList(source)));

        // конечный результат
        String[] finale = new String[]{
                "K1",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2",
                "K2",
                "K2/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        };

        List<ArrayLine> expected = sorting.convertToList(finale);
        System.out.println("Сортировка:");
        result.forEach(o -> System.out.println(o.toString()));

        assertThat(result, is(expected));
    }

    /**
     * Тестирование сортировки по убыванию.
     */
    @Test
    public void sortDown() throws Exception {
        List<ArrayLine> result = sorting.sortDwn(sorting.checkAndAdd(sorting.convertToList(source)));

        // конечный результат
        String[] finale = new String[]{
                "K2",
                "K2/SK1",
                "K2/SK1/SSK2",
                "K2/SK1/SSK1",
                "K1",
                "K1/SK2",
                "K1/SK1",
                "K1/SK1/SSK2",
                "K1/SK1/SSK1"
        };

        List<ArrayLine> expected = sorting.convertToList(finale);
        System.out.println("Сортировка:");
        result.forEach(o -> System.out.println(o.toString()));

        assertThat(result, is(expected));
    }
}