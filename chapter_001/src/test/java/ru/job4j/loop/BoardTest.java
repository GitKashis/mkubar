package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Test.
 *
 * @author Mikhail Kubar.
 * @version 1.0.
 * @since 26.08.2017.
 */
public class BoardTest {

    /**
     * Test board 3x3.
     */
    @Test
    public void paintThreeThree() {
        Board board = new Board();
        String result = board.paint(3, 3);
        final String line = System.getProperty("line.separator");
        String expected = String.format("x x%s x %sx x%s", line, line, line);
        assertThat(result, is(expected));
    }

    /**
     * Test board 5x4.
     */
    @Test
    public void paintFiveFour() {
        Board board = new Board();
        String result = board.paint(5, 4);
        final String line = System.getProperty("line.separator");
        String expected = String.format("x x x%s x x %sx x x%s x x %s", line, line, line, line);
        assertThat(result, is(expected));
    }

}