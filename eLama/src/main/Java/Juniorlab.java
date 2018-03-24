import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Juniorlab {

    public static long upsidedown(String x, String y) {
        long count = 0;
        Pattern r = Pattern.compile("2|3|4|5|7");

        for(BigInteger value = new BigInteger(x); !value.equals(new BigInteger(y)); value = value.add(BigInteger.ONE)) {
            String str = value.toString();
            Matcher m = r.matcher(str);
            if (!m.find()) {
                if(!Objects.equals(str, "6") || !Objects.equals(str, "9")) {
                    if (symmetry(str)) count++;
                }
//                System.out.println(value);
            }
        }
        return count;
    }

    public static boolean symmetry(String str) {
        boolean result = true;
        String[] chars = str.split("(?!^)");
        for (int i = 0; i <= str.length() / 2; i++) {
            String first = chars[i];
            String last = chars[str.length() - 1 - i];
            System.out.println(first + last);
                if ((!Objects.equals(first, last))) {
                    if ((Objects.equals(first + last, "69")) || (Objects.equals(first + last, "96"))) {
                        continue;
                    }
                result = false;
                break;
                }
            }
        return result;
    }

}
