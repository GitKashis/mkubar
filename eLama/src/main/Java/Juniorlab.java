import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Juniorlab {

    private static Pattern pattern; // подстрока
    private static Matcher matcher; // строка

    public static String[] inArray(String[] array1, String[] array2){
        List<String> list = new ArrayList<>();

        for (int i = 0; i < array1.length; i++) {
            pattern = Pattern.compile(array1[i]);
            for (int j = 0; j < array2.length; j++) {
                matcher = pattern.matcher(array2[j]);
                if (matcher.find()) {
                    list.add(array1[i]);
                    break;
                }
            }
        }

        return list.stream().sorted().toArray(String[]::new);
    }
}