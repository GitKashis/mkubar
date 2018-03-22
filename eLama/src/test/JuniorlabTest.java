import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JuniorlabTest {

    @Test
    public void test() {
        String example01 = "0 0 0 1 0 0";
        String example02 = "0 0 0 0 1 0 0";
        String example11 = "707 423 584 293 572 62";
        String example12 = "136 864 0 626 15 152 121";
        String example21 = "132 196 432 622 929 373";
        String example22 = "761 683 48 801 805 463 176";
        String example31 = "830 55 258 226 261 227";
        String example32 = "831 876 577 745 781 6 438";
        String example41 = "869 260 246 189 401 378";
        String example42 = "41 826 818 746 393 705 95";
        String example51 = "0 1 0 0 0 0";
        String example52 = "0 0 0 1 0 0 0";
//        assertEquals("Battle Result: No victor on this battle field", Juniorlab.goodVsEvil(example01, example02));
        assertEquals("Battle Result: Good triumphs over Evil", Juniorlab.goodVsEvil(example11, example12));
//        assertEquals("Battle Result: Good triumphs over Evil", Juniorlab.goodVsEvil(example21, example22));
//        assertEquals("Battle Result: Evil eradicates all trace of Good", Juniorlab.goodVsEvil(example31, example32));
//        assertEquals("Battle Result: Evil eradicates all trace of Good", Juniorlab.goodVsEvil(example41, example42));
//        assertEquals("Battle Result: No victor on this battle field", Juniorlab.goodVsEvil(example51, example52));
    }
}