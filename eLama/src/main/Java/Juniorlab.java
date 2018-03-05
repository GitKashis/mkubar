public class Juniorlab {

    public static String[] inArray(String[] array1, String[] array2){
        String[] result = new String[array1.length];
        int index = 0;

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (contains(array2[j], array1[i])) {
                    result[index++] = array1[i];
                    break;
                }
            }
        }

        String[] r = new String[index];

        for (int i = 0; i < index; i++) {
            r[i] = result[i];
        }
        bubbleSort(r);
        return r;
    }

    public static boolean contains(String origin, String sub) {
        /**
         * Для работы с отдельными символами строк
         * преобразуем String в массив типа Char.
         */
        char[] originCh = origin.toCharArray();
        char[] subCh = sub.toCharArray();

        //j - индекс подстроки.
        int j = 0;

        /*
         * Посимвольно проходим по строке поиска,
         * сравнивая соответствующие значения.
         * Выход из цикла:
         *  - при совпадении всех символов подстроки.
         *  - если полного совпадения нет, то
         *  выход по завершении строки поиска.
         */
        for (int i = 0; i < origin.length(); i++) {

            if (originCh[i] == subCh[j]) {
                j++;
            } else {
                j = 0;
            }

            if (j == sub.length()) {
                break;
            }
        }
        return j == sub.length();
    }

    public static void bubbleSort(String[] stringArray) {
        int n = stringArray.length;
        String temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (stringArray[j - 1].compareTo( stringArray[j] ) > 0) {
                    temp = stringArray[j - 1];
                    stringArray[j - 1] = stringArray[j];
                    stringArray[j] = temp;
                }
            }
        }
    }
}