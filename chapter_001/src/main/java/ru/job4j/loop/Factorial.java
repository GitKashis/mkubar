package ru.job4j.loop;
/**
 * Class Max. Решение задачи. Часть 001, урок 3.1
 * @author Mikhail Kubar
 * @since 26.08.2017
 */
public class Factorial {

    /**
     * @param n - число.
     * @return ret - факториал числа.
     */
    public int calc(int n) {
        int ret = 1;
        if (n < 0) {
            ret = 0;
        }

        if (n > 0) {
            for (int i = 1; i <= n; ++i) {
                ret *= i;
            }
        }
        return ret;
    }
}
