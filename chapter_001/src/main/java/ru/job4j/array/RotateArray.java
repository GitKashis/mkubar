package ru.job4j.array;

/**
 * Class RotateArray. Решение задачи. Часть 001, урок 5.2
 *
 * @author Mikhail Kubar
 * @since 28.08.2017
 */
public class RotateArray {
    /**
     * Метод принимает двумерный массив целых чисел,
     * возвращает массив, повёрнутый на 90 градусов по часовой стрелке.
     *
     * @param array - исходный массив.
     * @return array - повёрнутый.
     */
    public int[][] rotate(int[][] array) {
        int tmp;
        int m = array.length;
        for (int i = 0; i < m / 2; i++) {
            for (int j = i; j < m - 1 - i; j++) {
                tmp = array[i][j];
                array[i][j] = array[m - j - 1][i];
                array[m - j - 1][i] = array[m - i - 1][m - j - 1];
                array[m - i - 1][m - j - 1] = array[j][m - i - 1];
                array[j][m - i - 1] = tmp;
            }
        }
        return array;
    }
}
