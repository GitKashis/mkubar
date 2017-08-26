package ru.job4j.condition;

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
public class PointTest {

    /**
     * Test.
     * Проверяет принадлежность точки point (x, y)
     * функции вида y(x) = a*x + b.
     */
    @Test
    public void whenPointOnLineThenTrue() {
        //create of new point.
        Point point = new Point(3, 4);
        // execute method - is and get result;
        boolean result = point.is(1, 1);
        // assert result by excepted value.
        assertThat(result, is(true));
    }
}
