package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class BubbleSort. Решение задачи. Часть 001, урок 3.1
 * @author Mikhail Kubar
 * @since 28.08.2017
 */
public class BubbleSortTest {
    /**
     * @see package ru.job4j.array.BubleSort.java;
     */
    private BubbleSort sort = new BubbleSort();
    /**
     * @value myArray - несортированный массив.
     */
    private int[] myArray = {1, 3, 5, 2, 4};
    /**
     * Test BubleSort.
     */
    @Test
    public void sortBubleUp() {
        // вычисляем значение.
        int[] resultArray = sort.sort(myArray);
        // ожидаемый результат
        int[] expectArray = {1, 2, 3, 4, 5};
        assertThat(resultArray, is(expectArray));
    }
}