package ru.job4j.array;

/**
 * Решение задачи о слиянии двух массивов методом прямого перебора.
 *
 * @author Mikhail Kubar
 * @since 30.08.2017
 */
public class Merge {
    /**
     * Метод производит слияние двух массивов целочисленноо типа и возвращает отсортированный массив,
     * содержащий элементы первого и второго, заданных в качестве параметров.
     * @param a - первый массив.
     * @param b - второй массив
     * @return result.
     */
    public int[] twoArrays(int[] a, int[] b) {
        // По условию алгоритма они уже должны быть отсортированы.
        // Считываем размеры массивов, которые необходимо слить в один отсортированный массив.
        int n = a.length;
        int m = b.length;

        // Динамически выделяем память под хранение массива, полученного слиянием двух исходных,
        // его размер, очевидно, равен n + m.
        int[] result = new int[n + m];

        // Заведем два индекса, указывающих на первый необработанный элемент первого и второго массивов.
        int i = 0, j = 0;
        // И индекс массива-результата, который указывает позицию, которая будет заполнена на текущем шаге.
        int index = 0;

        // Будем повторять сравнение элементов массивов a и b до тех пор, пока в каждом из них
        // есть хотя бы один необработанный элемент.
        while (i < n && j < m) {
            // В соответствии с тем, текущий элемент какого массива меньше, мы записываем этот элемент
            // в массив-результат и обновляем нужный индекс (i или j).
            if (a[i] < b[j]) {
                result[index] = a[i];
                i++;
            } else {
                result[index] = b[j];
                j++;
            }
            index++;
        }

        // После выполнения предыдущего цикла все элементы одного из массивов будут обработаны,
        // тогда оставшиеся элементы другого массива нужно просто дописать в массив-результат.
        // Одно из условий (i < n) или (j < m) будет гарантированно ложно.

        while (i < n) {
            result[index] = a[i];
            index++;
            i++;
        }

        while (j < m) {
            result[index] = b[j];
            index++;
            j++;
        }
        return result;
    }
}
