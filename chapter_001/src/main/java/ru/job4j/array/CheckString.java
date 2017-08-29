package ru.job4j.array;

/**
 * Created by Миша2 on 29.08.2017.
 */
public class CheckString {
    public boolean contains (String origin, String sub) {
        boolean result = false;
        char[] originCh = origin.toCharArray();
        char[] subCh = sub.toCharArray();
        int i = 0;
        int j = 0;

        while (i < origin.length() && j < sub.length()) {
            result = false;
            if (originCh[i] == subCh[j]) {
                j++;
                result = true;
                }
                else j = 0;
            i++;
        }
        return result;
    }
}
