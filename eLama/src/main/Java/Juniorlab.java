import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Juniorlab {

    public static String chooseBestSum (int t, int k, int[] array) {
        List<Integer> ls = new ArrayList<>();
        for (int anArray : array) {
            ls.add(anArray);
        }

        if (t < 0 || k < 1 || k > ls.size()) {
            return null;
        }
        List<List<Integer>> townsDistances = new ArrayList<>();
        int[] counter = IntStream.range(0, k).toArray();
        int[] lastDist = IntStream.range((ls.size() - k), ls.size()).toArray();

        List<Integer> dist = IntStream.of(counter)
                .map(ls::get).boxed()
                .collect(Collectors.toList());
        townsDistances.add(dist);

        while (!Arrays.equals(counter, lastDist)) {
            for (int i = 0; i < ls.size(); i++) {
                int pos = (k - 1) - i;
                if (counter[pos] < (ls.size() - 1) - i) {
                    counter[pos]++;
                    for (int j = pos + 1; j < counter.length; j++) {
                        counter[j] = counter[j - 1] + 1;
                    }
                    break;
                }
            }
            dist = IntStream.of(counter)
                    .map(ls::get).boxed()
                    .collect(Collectors.toList());
            townsDistances.add(dist);
        }

        int result;
        try {
            result = townsDistances.stream()
                    .mapToInt(d
                            -> d.stream().mapToInt(Integer::intValue).sum())
                    .filter(distSum -> distSum <= t)
                    .max().getAsInt();
        } catch (NoSuchElementException e) {
            return null;
        }

        return String.valueOf(result);
    }

//    public static Optional<String> chooseBestSum (int t, int k, int[] array) {
//        Integer result = values(t,k,array);
//
//        return new Optional<String>(String.valueOf(result));
//    }

}