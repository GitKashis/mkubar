import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.ceil;


public class Juniorlab {

    /**
     * Количество вариантов до максимального разряда
     * @param x - минимальный разряд
     * @param y - максималный
     * @return
     */
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

    /**
     * Проверяем число последней разрядности
     * @param y
     * @return
     */
    static long last(String y) {
        int mid = (int) ceil(y.length() / 2.0);
        boolean isEven = y.length() % 2 == 0;
        String[] chars = y.split("(?!^)");

        // массив коэффициентов, которые будем перемножать
        int[] arr = new int[mid];
        int loss = 0;
        for (int i = 0; i < mid; i++) {
            // [истинное, остаток, остаток |_,_,_]
            arr[i] = func(Integer.parseInt(chars[i]), i, mid, isEven);
            if (i != 0) {
                loss += arr[i];
            }
        }
        System.out.println("loss = " + loss);
        // [истинное, 5, 5 |_,_,_]
        int[] truePoints = new int[mid];
        Arrays.fill(truePoints, 5);
        truePoints[0] = arr[0];
        System.out.println("truePoints " + Arrays.toString(truePoints));
        System.out.println("arr " + Arrays.toString(arr));
        return Arrays.stream(truePoints).asLongStream().reduce((x, z) -> x * z).getAsLong() - loss;
    }

    static int func(int digit, int pos, int mid, boolean isEven) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(0, 1, 6, 8, 9));
        List<Integer> points = new LinkedList<>();

        // если получен первый элемент - удаляем 0
        if (pos == 0) {
            queue.remove();
        }                   // {1, 6, 8, 9}

        //если получен мид
        if ((pos == mid) && (!isEven)) {
            //если нечетное, то только три элемента {0, 1, 8}
            queue.removeAll(Arrays.asList(6, 9));
        }

        //запушить подходящие
        while(queue.peek() <= digit) {
            points.add(queue.poll());
            if (queue.isEmpty()) break;
        }

       // points.forEach(System.out::print);
        return pos == 0 ? points.size() : queue.size();
    }

}


