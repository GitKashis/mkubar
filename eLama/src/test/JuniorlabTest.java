import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

import java.util.Arrays;

public class JuniorlabTest {


    @Test
    public void gcd_6() {
        String[] example01 = {"tarp", "mice", "bull"};
        String[] example02 = {"lively", "alive", "harp", "sharp", "armstrong"};

        String[] example11 = {"xyz", "live", "strong"};
        String[] example12 = {"lively", "alive", "harp", "sharp", "armstrong"};

        String[] example21 = {"live", "strong", "arp"};
        String[] example22 = {"lively", "alive", "harp", "sharp", "armstrong"};

        assertArrayEquals(new String[]{}, Juniorlab.inArray(example01, example02));
        assertArrayEquals(new String[]{"live", "strong"}, Juniorlab.inArray(example11, example12));
        assertArrayEquals(new String[]{"arp", "live", "strong"}, Juniorlab.inArray(example21, example22));
    }
}