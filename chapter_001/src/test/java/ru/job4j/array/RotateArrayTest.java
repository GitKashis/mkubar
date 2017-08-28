package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Mikhail Kubar
 * @version 1.0
 * @since 28.08.2017
 */
public class RotateArrayTest {
    /**
     * @see package ru.job4j.array.
     */
    private RotateArray myArray = new RotateArray();
    /**
     * Testing rotate with array 2x2.
     * @value target - исходный массив.
     */
    @Test
    public void RotateArrayTestWithFourElements(){
        int[][] target = {
                {0, 1},
                {2, 3}
        };
        //вычисляем результат.
        int[][] result = myArray.rotate(target);
        // Задаем ожидаемый результат.
        int[][] expected = {
                {2, 0},
                {3, 1}
        };
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }
    /**
     * Testing rotate with array 3x3.
     * @value target - исходный массив.
     */
    @Test
    public void RotateArrayTestWithNineElements(){
        int[][] target = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };
        //вычисляем результат.
        int[][] result = myArray.rotate(target);
        // Задаем ожидаемый результат.
        int[][] expected = {
                {6, 3, 0},
                {7, 4, 1},
                {8, 5, 2}
        };
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }
}