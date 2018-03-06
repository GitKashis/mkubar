import java.math.BigInteger;

public class Juniorlab {

    public static int zeros(int n){
        char[] s = factorial(n).toString().toCharArray();
        int count = 0;
        for (int i = s.length - 1; i > 0; i--) {
            if (s[i] == '0') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static BigInteger factorial(int n) {
        BigInteger ret = BigInteger.ONE;
        for (int i = 1; i <= n; ++i) ret = ret.multiply(BigInteger.valueOf(i));
        System.out.println(ret);
        return ret;
    }
}