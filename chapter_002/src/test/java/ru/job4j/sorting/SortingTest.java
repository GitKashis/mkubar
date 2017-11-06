package ru.job4j.sorting;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class SortingTest {
    @Test
    public void sort() throws Exception {

        String[] source = new String[]{
                "K1/SK1",
                "K1/SK2",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K2",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        };

        Sorting sorting = new Sorting();
        List<ArrayLine> convertedArray = sorting.convertToList(source);
        List<ArrayLine> result = sorting.sort(sorting.checkAndAdd(convertedArray));

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
        result.forEach(o -> System.out.println(o.toString()));

        assertThat(result, is(expected));
    }

}