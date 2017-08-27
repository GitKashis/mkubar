package ru.job4j.max;

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
public class MaxTest {
    /**
     * Test Max.
     * Метод max из класса Max.
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }
    /**
     * Test Max of three.
     * Метод max из класса Max.
     */
    @Test
    public void whenFirstLessSecondThree() {
        Max maxim = new Max();
        int result = maxim.max(1, 2, 3);
        assertThat(result, is(3));
    }
}
