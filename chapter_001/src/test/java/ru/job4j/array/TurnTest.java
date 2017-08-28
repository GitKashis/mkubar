package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 *
 * @author Mikhail Kubar.
 * @version 1.0.
 * @since 28.08.2017.
 */
public class TurnTest {

    /**
     * @see package ru.job4j.array.
     */
    private Turn turn = new Turn();
    /**
     * Метод переворота массива с чётным числом элементов.
     * @value target - исходный массив.
     */
    @Test
    public void turnWithEvenElements() {
        int[] target = {0, 1, 2, 3, 4, 5};
        //вычисляем результат.
        int[] result = turn.back(target);
        // Задаем ожидаемый результат.
        int[] expected = {5, 4, 3, 2, 1, 0};
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }
    /**
     * Метод переворота массива с нечётным числом элементов.
     * @value target - исходный массив.
     */
    @Test
    public void turnWithOddElements() {
        int[] target = {1, 2, 3, 4, 5};
        //вычисляем результат.
        int[] result = turn.back(target);
        // Задаем ожидаемый результат.
        int[] expected = {5, 4, 3, 2, 1};
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }
}

