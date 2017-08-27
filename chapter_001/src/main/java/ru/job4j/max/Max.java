package ru.job4j.max;

/**
 * Class Max. Решение задачи. Часть 001, урок 3.1
 * @author Mikhail Kubar
 * @since 26.08.2017
 */
public class Max {
    /**
     * Определение максимума из двух чисед.
     * @param first - первое число.
     * @param second - второе.
     * @return result.
     */
    public int max(int first, int second) {
        return (first > second ? first : second);
    }

    /**
     * Определение максимума из двух чисед.
     * @param first - первое число.
     * @param second - второе.
     * @param third - третье.
     * @return result.
     */
    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }

}
