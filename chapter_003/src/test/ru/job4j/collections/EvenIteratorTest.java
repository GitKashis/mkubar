package ru.job4j.collections;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Testing EvenIterator.
 * Created by Kubar on 07.10.2017.
 */
public class EvenIteratorTest {

    /**
     * Тестирование метода hasNext().
     * После второго вызова четных нет, поэтому должно вернуть false.
     */
    @Test
    public void hasNext() throws Exception {
        EvenIterator it = new EvenIterator(new int[]{1, 2, 1, 4, 1});

        it.next();
        it.next();
        boolean result = it.hasNext();

        assertThat(result, is(false));
    }

    /**
     * Тестирование метода next().
     * Дважды вызываем итератор,
     * сначала остановится на '2', потом на '4'.
     *
     */
    @Test
    public void nextInt() throws Exception {
        EvenIterator it = new EvenIterator(new int[]{1, 2, 1, 4, 1});

        it.next();
        int result = (Integer) it.next();

        assertThat(result, is(4));
    }

    /**
     * Тестирование исключения в методе next().
     * Четных нет, должно выкинуть ошибку NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextThenException() throws Exception {
        EvenIterator it = new EvenIterator(new int[]{1, 1, 1, 1, 1});
        it.next();
    }
}