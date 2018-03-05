import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Juniorlab {

    public static int[] findAll(int n, int k){
        // список для подходящих значений
        List<Integer> list = new ArrayList<>();
        // ищем в заданном диапазоне методом перебора значений
        for (int i = (int) Math.pow(10,k-1); i < Math.pow(10,k); i++) {
            //конвертируем для получения цифр поазрядно
            String s = "" + i;
            int arr[] = new int[s.length()];

            // переводим число в массив цифр
            for (int count = 0; count < s.length(); count++) {
                arr[count] = Integer.parseInt(String.valueOf(s.charAt(count)));
            }
            // отсеиваем лишнее и выбираем нужное
            if (sum(arr) == n && !s.contains("0") && check(arr)) {
                list.add(i);
            }
        }

        int[] result = list.isEmpty() ? new int[]{} : new int[]{list.size(), list.get(0), list.get(list.size()-1)} ;
        return result;
    }
    /**
     * Метод подсчета суммы элементов массива.
     */
    private static int sum(int[] arr) {
        return Arrays.stream(arr).sum();
    }
    /**
     * Проверяем, идут ли цифры числа по возрастанию.
     */
    private static boolean check(int[] arr) {
        boolean result = true;
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
