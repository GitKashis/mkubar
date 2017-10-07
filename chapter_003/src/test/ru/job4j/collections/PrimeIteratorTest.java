package ru.job4j.collections;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тестирование итератора, возвращающего только простые числа.
 * Created by Kubar on 08.10.2017.
 */
public class PrimeIteratorTest {
    /**
     * Тестирование метода hasNext().
     * После второго вызова простых нет, поэтому должно вернуть false.
     */
    @Test
    public void hasNext() throws Exception {
        PrimeIterator it = new PrimeIterator(new int[]{3, 4, 5, 6, 4});

        it.next();
        it.next();
        boolean result = it.hasNext();

        assertThat(result, is(false));
    }

    /**
     * Тестирование метода next().
     * Дважды вызываем итератор,
     * сначала остановится на '3', потом на '5'.
     *
     */
    @Test
    public void nextPrime() throws Exception {
        PrimeIterator it = new PrimeIterator(new int[]{3, 4, 5, 6, 7});

        it.next();
        int result = (Integer) it.next();

        assertThat(result, is(5));
    }

    /**
     * Тестирование исключения в методе next().
     * Простых нет, должно выкинуть ошибку NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextThenException() throws Exception {
        PrimeIterator it = new PrimeIterator(new int[]{4, 8, 4, 4, 6});
        it.next();
    }
}