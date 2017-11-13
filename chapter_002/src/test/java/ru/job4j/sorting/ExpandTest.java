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


    @Test
    public void expand() throws Exception {

    ExpandSet expand = new ExpandSet();

        Set<String[]> result = expand.expand(source);
        System.out.println("Проверка добавления элементов:");
        result.forEach(o -> System.out.println(Arrays.toString(o)));

        assertThat(result.size(), is(9));
    }

}