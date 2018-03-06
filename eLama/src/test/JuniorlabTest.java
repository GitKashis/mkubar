import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JuniorlabTest {
    @Test
    public void testExample() {
        int example01 = 12;
        int example11 = 1000000000;
        int example21 = 100000;
        int example31 = 1000;
        int example41 = 100;
        int example51 = 30;
        int example61 = 6;
//        assertEquals(2, Juniorlab.zeros(example01));
        assertEquals(24999, Juniorlab.zeros(example21));
//        assertEquals(249, Juniorlab.zeros(example31));
//        assertEquals(24, Juniorlab.zeros(example41));
//        assertEquals(7, Juniorlab.zeros(example51));
//        assertEquals(1, Juniorlab.zeros(example61));
    }
}