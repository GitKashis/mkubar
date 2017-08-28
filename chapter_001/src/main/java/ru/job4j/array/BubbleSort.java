package ru.job4j.array;
/**
 * Class BubbleSort. Решение задачи. Часть 001, урок 5.1
 * @author Mikhail Kubar
 * @since 28.08.2017
 */
public class BubbleSort {
    /**
     * Метод сортирует заданный массив целых чисел
     * по алгоритму пузырьковой сортировки по возрастанию.
     * @param array - на входе несортированный массив.
     * @return array - на выходе отсортированный.
     */
    public int[] sort(int[] array) {
        // swapped - переменная, которая отвечает за упорядоченность эелемнтов в массиве.
        boolean swapped = true;
        // temp - временное хранение, где будут меняться элементы по возрастанию.
        int temp;
        // j - счетчик цикла while.
        int j = 0;
        do {
            swapped = false;
            j++;
            for (int i = 0; i < array.length - 1; i++) {
                // например: если элемент под индексом i=1, т.е. 11, больше элемента
                // под индексом i=2, т.е. 4, то меняем их местами.
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        // делаем это условие пока все элементы в массиве не будут соответсвовать условию.
        return array;
    }
}
