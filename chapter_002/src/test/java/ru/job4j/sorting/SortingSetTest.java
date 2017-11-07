package ru.job4j.sorting;

import org.junit.Test;
import java.util.Set;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortingSetTest {
    // инициализация
    SortingSet sorting = new SortingSet();
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
    public void convertAndAddToSet() throws Exception {
        Set<ArrayLine> result = sorting.convertAndAddToSet(source);
        System.out.println("Проверка добавления элементов:");
        result.forEach(o -> System.out.println(o.toString()));

        assertThat(result.size(), is(9));
    }
}
