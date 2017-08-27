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
public class FactorialTest {

    /**
     * Test zero.
     */
    @Test
    public void calcZero() {
        Factorial factorial = new Factorial();
        //Проверяем результат и ожидаемое значение.
        assertThat(factorial.calc(0), is(1));
    }
    /**
     * Test for five.
     */
    @Test
    public void calcFive() {
        Factorial factorial = new Factorial();
        //Проверяем результат и ожидаемое значение.
        assertThat(factorial.calc(6), is(720));
    }
    /**
     * Test for negative.
     */
    @Test
    public void calcNegative() {
        Factorial factorial = new Factorial();
        //Проверяем результат и ожидаемое значение.
        assertThat(factorial.calc(-6), is(0));
    }
}