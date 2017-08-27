package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Mikhail Kubar.
 * @version 1.0.
 * @since 26.08.2017.
 */
public class CounterTest {

    /**
     * Test.
     */
    @Test
    public void add() {
        Counter counter = new Counter();
        // Вычисляем
        int result = counter.add(1, 3);
        // Задаем ожидаемый результат.
        int expected = 2;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }

}