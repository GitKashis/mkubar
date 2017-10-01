package ru.job4j.collections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * //todo
 * Created by Kubar on 02.10.2017.
 */
public class Converter {

    /**
     * В метод приходит двумерный массив целых чисел, необходимо пройтись по всем
     * элементам массива и добавить их в List<Integer>.
     *
     * @param array.
     * @return List.
     */
    private static List<Integer> toList(int[][] array) {
        List<Integer> thisList = new LinkedList<>();
        for (int[] scope : array) {
            for (int value : scope) {
                thisList.add(value);
            }
        }
        return thisList;
    }

    /**
     * Метод toArray должен равномерно разбить лист на количество строк двумерного массива.
     * В методе toArray должна быть проверка - если количество элементов не кратно количеству
     * строк - оставшиеся значения в массиве заполнять нулями.
     *
     * @param list
     * @param rows
     * @return
     */
    private static int[][] toArray(List<Integer> list, int rows) {
        int value = list.size();
        int cols;
        boolean isReady;
        do {
            cols = value / rows;
            isReady = true;
            if (value % rows != 0) {
                value++;
                isReady = false;
            }
        }
        while (!isReady);
        System.out.println("row = " + rows + ", cols = " + cols);

        int[][] result = new int[rows][cols];
        int count = 0;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                if (count < list.size())
                    result[i][j] = list.get(count);
                else result[i][j] = 0;
                count++;
            }
        return result;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> integers = toList(array);
        System.out.println(integers.toString());
        integers.remove(7);
        integers.remove(7);
        System.out.println(integers.toString());

        int[][] result = toArray(integers, 3);
        System.out.println(Arrays.deepToString(result));
    }
}
