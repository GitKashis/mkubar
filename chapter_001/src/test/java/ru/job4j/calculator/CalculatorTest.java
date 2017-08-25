package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Mikhail Kubar.
 * @version 1.0.
 * @since 25.08.2017.
 */
public class CalculatorTest {
/**
 * Test addition.
 * Метод echo из класса Calculate.
 */
	@Test
	public void whenAddOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.add(1D, 1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat(result, is(expected));
}
 /**
  * Test substruction.
  */
    @Test
    public void whenAddThreePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.substruct(3D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
/**
 * Test division.
 * Метод echo из класса Calculate.
 */
    @Test
    public void whenAddFourPlusTwoThenTwo() {
        Calculator calc = new Calculator();
        calc.div(4D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
/**
 * Test division.
 * Метод echo из класса Calculate.
 */
    @Test
    public void whenAddTwoPlusTwoThenFour() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 2D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }
}