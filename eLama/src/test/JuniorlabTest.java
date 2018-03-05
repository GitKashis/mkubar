import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.util.Arrays;

import static org.junit.Assert.*;

public class JuniorlabTest {


    @Test
    public void gcd_6() {
        int example01 = 35;
        int example02 = 6;
        int example11 = 10;
        int example12 = 3;
        int example21 = 27;
        int example22 = 3;
        int example31 = 84;
        int example32 = 4;
        assertEquals({123, 116999, 566666}, Juniorlab.findAll(example01, example02));
        assertEquals({8, 118, 334}, Juniorlab.findAll(example11, example12));
        assertEquals({1, 999, 999}, Juniorlab.findAll(example21, example22));
        assertEquals({}, Juniorlab.findAll(example31, example32));
    }
}