import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JuniorlabTest {

    @Test
    public void test() {
        int example01 = 163;
        int example02 = 3;
        int[] example03 = {50, 55, 56, 57, 58};
        int example11 = 331;
        int example12 = 2;
        int[] example13 = {1000, 640, 1230, 2333, 1440, 500, 1320, 1230, 340, 890, 732, 1346};
        int example21 = 100;
        int example22 = 2;
        int[] example23 = {100, 76, 56, 44, 89, 73, 68, 56, 64, 123, 2333, 144, 50, 132, 123, 34, 89};
        int example31 = 700;
        int example32 = 6;
        int[] example33 = {91, 74, 73, 85, 73, 81, 87};
        int example41 = 331;
        int example42 = 4;
        int[] example43 = {91, 74, 73, 85, 73, 81, 87};
        int example51 = 331;
        int example52 = 2;
        int[] example53 = {91, 74, 73, 85, 73, 81, 87};
        int example61 = 230;
        int example62 = 3;
        int[] example63 = {91, 74, 73, 85, 73, 81, 87};
        int example71 = 163;
        int example72 = 3;
        int[] example73 = {50};
        assertEquals(new Integer(163), Juniorlab.chooseBestSum(example01, example02, example03));
        assertEquals(null, Juniorlab.chooseBestSum(example11, example12, example13));
        assertEquals(new Integer(100), Juniorlab.chooseBestSum(example21, example22, example23));
        assertEquals(new Integer(491), Juniorlab.chooseBestSum(example31, example32, example33));
        assertEquals(new Integer(331), Juniorlab.chooseBestSum(example41, example42, example43));
        assertEquals(new Integer(178), Juniorlab.chooseBestSum(example51, example52, example53));
        assertEquals(new Integer(228), Juniorlab.chooseBestSum(example61, example62, example63));
        assertEquals(null, Juniorlab.chooseBestSum(example71, example72, example73));
    }
}