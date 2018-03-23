import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;


public class Juniorlab {

    public static long upsidedown(String x, String y) {
        long count = 0;
        for(BigInteger value = new BigInteger(x);
            !value.equals(new BigInteger(y)); value = value.add(BigInteger.ONE)) {
            if (symmetry(value.toString())) {
                count++;
            }
        }
        return count;
    }

    public static boolean symmetry(String str) {
        final List<String> pair = Arrays.asList("00","11","88","96", "69");
        boolean result = true;
        String[] chars = str.split("(?!^)");
        for (int i = 0; i <= str.length() / 2; i++) {
            String value = chars[i] + chars[str.length() - 1 - i];
            if(!pair.contains(value)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
