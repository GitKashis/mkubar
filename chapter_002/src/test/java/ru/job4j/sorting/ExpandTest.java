package ru.job4j.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ExpandTest {
    @Test
    public void expand() throws Exception {
    Expand expand = new Expand();
        List<Integer> value = Arrays.asList(1, 2, 3);
        List<List<Integer>> result = expand.expand(value);

        System.out.println(result.toString());
        //assertThat(result, is(expected));
    }

}