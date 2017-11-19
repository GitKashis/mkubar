package ru.job4j.simplearray;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тестирование simplearray
 * Created by Kubar on 08.10.2017.
 */
public class SimpleArrayTest {
    private SimpleArray<Integer> array;

    @Before
    public void setUp() {
        array = new SimpleArray<>(4);
        array.add(54);
        array.add(4);
        array.add(5);
        array.add(11);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get() {
        assertThat(array.get(0), is(54));
        assertThat(array.get(1), is(4));
        assertThat(array.get(2), is(5));
        assertThat(array.get(3), is(11));

        assertThat(array.get(33), is(11));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void delete() {
        // длина массива = 4
        array.delete(1);
        assertThat(array.get(1), is(5));
        // длина массива = 3
        array.delete(1);
        assertThat(array.get(1), is(11));
        // длина массива = 2
        array.delete(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void update() {
        array.update(1, 99);
        assertThat(array.get(1), is(99));

        array.update(2, 88);
        assertThat(array.get(2), is(88));

        array.update(3, 33);
        assertThat(array.get(3), is(33));

        array.update(4, 33);
    }

    @Test
    public void getIndex() {
        assertThat(array.getIndex(54), is(0));
        assertThat(array.getIndex(4), is(1));
        assertThat(array.getIndex(5), is(2));
        assertThat(array.getIndex(11), is(3));

        assertThat(array.getIndex(99), is(-1));
    }
}