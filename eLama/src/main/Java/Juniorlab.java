import java.util.*;

public class Juniorlab {
    public static String goodVsEvil(String good, String evil) {
        int[] goodScore = new int[]{1, 2, 3, 3, 4, 10};
        int[] evilScore = new int[]{1, 2, 2, 2, 3, 5, 10};

        int[] goodInt = Arrays.stream(good.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] evilInt = Arrays.stream(evil.split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = Arrays.stream(goodInt).map(() -> goodInt[i] * goodScore[i]).sum();
        System.out.println(sum);

//        int[] goodResult = new int[goodInt.length];
//        for (int i = 0; i < goodInt.length; i++) {
//            goodResult[i] = goodInt[i] * goodScore[i];
//        }
//
//        int[] evilResult = new int[evilInt.length];
//        for (int i = 0; i < evilInt.length; i++) {
//            evilResult[i] = evilInt[i] * evilScore[i];
//        }
//
//        int result = Arrays.stream(goodResult).sum() - Arrays.stream(evilResult).sum();
//        if (result == 0) return "Battle Result: No victor on this battle field";
//        else return result > 0 ? "Battle Result: Good triumphs over Evil" : "Battle Result: Evil eradicates all trace of Good";
    return null;
    }
}