import java.awt.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Juniorlab {

    static int[] codeFromKey(String key) {
        // Key must not have double letters
        char[] keyChar = key.toCharArray();
        char[] array = key.toCharArray();
        Arrays.sort(array);
        String s = String.valueOf(array);
        int[] result = new int[keyChar.length];
        for(int i = 0; i < key.length(); i++) {
            result[i] = s.indexOf(keyChar[i]);
        }
        return result;
    }

    public static String deNico(String key, String message){
        int[] keyInt = codeFromKey(key);
        char[] s = message.trim().toCharArray();

        StringBuilder sb = new StringBuilder();
        String[][] array = source(s, keyInt.length);
        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j < keyInt.length; j++) {
                sb.append(array[i][keyInt[j]]);
            }
        }
        String str = sb.toString();
        if (str.length() > 0 && str.charAt(str.length() - 1) == ' ') {
             return str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static String[][] source(char[] s, int len) {
        String[][] result = new String[s.length / len + 1][len];
        int index = 0;
        for (int j = 0; j <= s.length / len; j++) {
            for (int i = 0; i < len; i++) {
                if(index < s.length) {
                    result[j][i] = String.valueOf(s[index++]);
                } else result[j][i] = "";
            }
        }
        return result;
    }
}