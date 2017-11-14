package ru.job4j.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ExpandTest {

    String[] source = new String[]{
            "K1/SK1",
            "K1/SK2",
            "K1/SK1/SSK1",
            "K1/SK1/SSK2",
            "K2",
            "K2/SK1/SSK1",
            "K2/SK1/SSK2"
    };

    ExpandSet expand = new ExpandSet();

    /**
     * Проверка добавления элементов
     */
    @Test
    public void expand() throws Exception {

        Set<List<String>> result = expand.expand(source);
        System.out.println("Проверка добавления элементов:");
        result.forEach(o -> System.out.println(o.toString()));

        assertThat(result.size(), is(9));
    }

    /**
     * Тестирование сортировки по возрастанию.
     */
    @Test
    public void sortUp() throws Exception {
        Set<List<String>> out = expand.expand(source);
        Set<String[]> result = expand.sortUp(out);

        // конечный результат
        String[] expected = new String[]{
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


        System.out.println("Сортировка по возрастанию:");
        result.forEach(o -> System.out.println(Arrays.toString(o)));

        //assertThat(result, is(expected));
    }

    /**
     * Тестирование сортировки по убыванию.
     */
    @Test
    public void sortDown() throws Exception {
        Set<List<String>> out = expand.expand(source);
        Set<String[]> result = expand.sortDwn(out);

        // конечный результат
        String[] expected = new String[]{
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

        System.out.println("Сортировка по убыванию:");
        result.forEach(o -> System.out.println(Arrays.toString(o)));
        //assertThat(result, is(expected));
    }
}