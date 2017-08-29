package ru.job4j.array;

/**
 * Class CheckString. Тестовое задание. Часть 001.
 *
 * @author Mikhail Kubar
 * @since 29.08.2017
 */
public class CheckString {

    /**
     * Метод проверяет вхождение подстроки в строку.
     *
     * @param origin строка, в которой ведется поиск.
     * @param sub    подстрока для поиска.
     * @return true / false.
     */
    public boolean contains(String origin, String sub) {
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
}
