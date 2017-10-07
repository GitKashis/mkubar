package ru.job4j.collections;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Итератор двумерного массива.
 * <p>
 * Created by Kubar on 07.10.2017.
 */
public class ArrayIteratorTest {
    private ArrayIterator it = new ArrayIterator(new int[][]{
            {1, 2},
            {3, 4}
    });

    /**
     * Проверить, есть ли еще элементы.
     * Сравнивает длинну массива с позицией курсора.
     */
    @Test
    public void hasNext() throws Exception {
        it.next();
        it.next();
        it.next();
        it.next();
        boolean result = it.hasNext();
        assertThat(result, is(false));
    }

    /**
     * Взятие следующего элемента: проход по "строке" до конца, переход на новую.
     * Сначала берётся элемент, потом переводится каретка.
     */
    @Test
    public void next() throws Exception {
        it.next();
        it.next();
        it.next();
        int result = (Integer) it.next();
        assertThat(result, is(4));
    }
}