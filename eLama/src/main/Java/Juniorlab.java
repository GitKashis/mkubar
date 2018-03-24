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
        Pattern r = Pattern.compile("[23457]");

        for(BigInteger value = new BigInteger(x); !value.equals(new BigInteger(y)); value = value.add(BigInteger.ONE)) {
            String str = value.toString();
            Matcher m = r.matcher(str);
            if (!m.find()) {
                 count++;
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

  {
                result = false;
                break;
            }
        }
        return result;
    }
}
