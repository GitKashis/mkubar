package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Миша2 on 29.08.2017.
 */
public class CheckStringTest {
    @Test
    public void containsTest() {
        CheckString check = new CheckString();
        String origin = "Hello world";
        String sub = "ldk";

        boolean result = check.contains(origin, sub);
        boolean expected = true;
        assertThat(result, is(expected));
    }

}