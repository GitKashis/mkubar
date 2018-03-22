import java.util.*;

public class Juniorlab {
    public static String goodVsEvil(String good, String evil) {
        int[] goodPoint = new int[]{1, 2, 3, 3, 4, 10};
        int[] evilPoint = new int[]{1, 2, 2, 2, 3, 5, 10};

        int[] goodInt = Arrays.stream(good.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] evilInt = Arrays.stream(evil.split(" ")).mapToInt(Integer::parseInt).toArray();

        int result = score(goodInt, goodPoint) - score(evilInt, evilPoint);
        if (result == 0) {
            return "Battle Result: No victor on this battle field";
        }
        else {
            return result > 0 ? "Battle Result: Good triumphs over Evil" : "Battle Result: Evil eradicates all trace of Good";
        }
    }

    private static int score(int[] source, int[] multiplier) {
        int sum = 0;
        for(int i = 0; i < source.length; i++) {
            sum += source[i] * multiplier[i];
        }
        return sum;
    }
}