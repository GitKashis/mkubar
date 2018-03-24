import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.ceil;


public class Juniorlab {

    public static long upsidedown(String x, String y) {
        long sum = 0;
        for (int i = x.length(); i <= y.length(); i++) {
            sum += check(i);
        }
        return sum;
    }

    /**
     * Метод получает количество разрядов числа (например для 999 количество разрядов = 3)
     * В первом разряде может быть только 4 варианта {1, 6, 8, 9}
     * Если четое, то в ближайшем слева от середины может быть 5 вариантов, если нечетоное, то 3 {0, 1, 8}
     * В остальных разрядах по 5 вариантов {0, 1, 6, 8, 9}
     * @param len - количество разрядов в строке
     * @return максимальное количество чисел, которые можно получить в строке данной разрядности.
     */
    static long check(int len) {
        int mid = (int) ceil(len / 2.0);
        int[] arr = new int[mid];
        Arrays.fill(arr, 5);
        arr[0] = 4;
        if(len % 2 != 0) {
            arr[mid - 1] = 3;
        }
        return Arrays.stream(arr).asLongStream().reduce((x, y) -> x * y).getAsLong();
    }

    static long range(String y) {
        int mid = (int) ceil(y.length() / 2.0);
        boolean isEven = y.length() % 2 == 0;
        int[] arr = new int[mid];
        String[] chars = y.split("(?!^)");

        for (int i = 0; i < mid; i++) {
            arr[i] = func(Integer.parseInt(chars[i]), isEven);
        }
        return Arrays.stream(arr).asLongStream().reduce((x, y) -> x * y).getAsLong();
    }

    static int func(int digit, boolean isEven) {
        int count = 0;
        List<Integer> list = Arrays.asList(0, 1, 6, 8, 9);
        while(value >= digit) {
            int value = list.;
            count++;
        }
        return count;
    }
}
