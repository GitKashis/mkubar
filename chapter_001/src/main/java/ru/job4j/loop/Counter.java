package ru.job4j.loop;
/**
 * Class Max. Решение задачи. Часть 001, урок 3.1
 * @author Mikhail Kubar
 * @since 26.08.2017
 */
public class Counter {

    /**
     * @value result - сумма в интервале.
     */
    private int result = 0;

    /**
     * @param start - начальное значение.
     * @param finish - конечное значение.
     * @return result - значение.
     */
    public int add(int start, int finish) {
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }
}
