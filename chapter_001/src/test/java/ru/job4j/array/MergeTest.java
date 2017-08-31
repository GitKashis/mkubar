package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class Merge. Решение задачи о слиянии массивов.
 * @author Mikhail Kubar
 * @since 30.08.2017
 */
public class MergeTest {
    /**
     * Создадим класс-обертку для метода слияния.
     * {@link ru.job4j.array.Merge}
     * @see package ru.job4j.array;
     */
    private Merge merge = new Merge();

    /**
     * Инициализируем изаполняем входные данные.
     * @value first - первый массив.
     * @value second - второй массив.
     */
    private int[] first = {1, 3, 5, 7, 9};
    private int[] second = {0, 2, 4, 6, 8};

    /**
     * Test.
     * {@link ru.job4j.array.Merge#twoArrays(int[], int[])}
     */
    @Test
    public void twoArraysTest() {
        // вычисляем значение.
        int[] resultArray = merge.twoArrays(first, second);
        // ожидаемый результат
        int[] expectArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(resultArray, is(expectArray));
    }
}