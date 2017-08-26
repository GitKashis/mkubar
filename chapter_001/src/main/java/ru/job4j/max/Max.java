package ru.job4j.max;

/**
 * Class Max. Решение задачи. Часть 001, урок 3.1
 * @author Mikhail Kubar
 * @since 26.08.2017
 */
public class Max {
    /**
     * Определение максимума.
     * @param first - первое число.
     * @param second - второе.
     * @return result
     */
    public int max(int first, int second) {
        return (first > second ? first : second);
    }
}
