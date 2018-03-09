import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

import java.util.Arrays;

public class JuniorlabTest {

    @Test
    public void test() {
        String example01 = "6gr5";
        String example02 = "e pfjgut 1uv";
        String example11 = "crazy";
        String example12 = "cseerntiofarmit on  ";
        String example21 = "crazy";
        String example22 = "cseerntiofarmit on";
        String example31 = "abc";
        String example32 = "abcd";
        String example41 = "ba";
        String example42 = "2143658709";
        String example51 = "a";
        String example52 = "message";
        String example61 = "key";
        String example62 = "eky";
        String example71 = "xemd";
        String example72 = "n69m73qk62uf6wrfijayycbyxn6dr7aalwna swc";
        assertEquals(" pfegutj1uv", Juniorlab.deNico(example01, example02));
        assertEquals("secretinformation", Juniorlab.deNico(example11, example12));
        assertEquals("secretinformation", Juniorlab.deNico(example21, example22));
        assertEquals("abcd", Juniorlab.deNico(example31, example32));
        assertEquals("1234567890", Juniorlab.deNico(example41, example42));
        assertEquals("message", Juniorlab.deNico(example51, example52));
        assertEquals("key", Juniorlab.deNico(example61, example62));
        assertEquals("m69nk3q7f2u6fwr6yjaiycbydn6xa7arawnlcsw", Juniorlab.deNico(example71, example72));
    }
}