package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Mikhail Kubar.
 * @version 1.0.
 * @since 27.08.2017.
 */
public class PaintTest {
    /**
     * line.separator.
     */
    private String line = System.getProperty("line.separator");
    /**
     * Test hight 2.
     */
    @Test
    public void paintTwo() {
        Paint paint = new Paint();
        String result = paint.piramid(2);
        String expected = String.format(" ^ %s^^^%s", line, line);
        assertThat(result, is(expected));
    }
    /**
     * Test hight 3.
     */
    @Test
    public void paintThree() {
        Paint paint = new Paint();
        String result = paint.piramid(3);
        String expected = String.format("  ^  %s ^^^ %s^^^^^%s", line, line, line);
        assertThat(result, is(expected));
    }
}