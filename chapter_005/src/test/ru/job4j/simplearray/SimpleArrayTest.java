package ru.job4j.simplearray;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


/**
 * Тестирование simplearray
 * Created by Kubar on 08.10.2017.
 */
public class SimpleArrayTest {

    @Test
    public void add() throws Exception {
        SimpleArray<Integer> array = new SimpleArray<>(4);

        array.add(54);
        array.add(4);
        array.add(5);
        array.add(11);

        int result = array.get(2);
        assertThat(result, is(5));
    }

    @Test
    public void delete() throws Exception {
        SimpleArray<Integer> array = new SimpleArray<>(4);

        array.add(54);
        array.add(4);
        array.add(5);

        array.delete(1);
        assertThat(array.get(1), is(5));
    }

    @Test
    public void update() throws Exception {
        SimpleArray<Integer> array = new SimpleArray<>(4);

        array.add(54);
        array.add(4);
        array.add(5);

        array.update(1, 99);
        assertThat(array.get(1), is(99));
    }
}