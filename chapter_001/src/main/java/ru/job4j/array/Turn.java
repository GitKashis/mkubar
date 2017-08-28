package ru.job4j.array;

/**
 * Class Max. Решение задачи. Часть 001, урок 5.0
 * @author Mikhail Kubar
 * @since 28.08.2017
 */
public class Turn {
    /**
     * Метод инвертирования массива чисел.
     * @param array - исходный массив.
     * @return - измененный массив.
     */
    public int[] back(int[] array) {
        /* Находим середину массива
         * с округлением в меньшую сторону.
         * @value count.
         */
        int count = (int) Math.floor(array.length / 2);
        /*
         * temp переменная-буфер, служит для обмена значений.
         */
        int temp = 0;

        for (int i = 0; i < count; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}
