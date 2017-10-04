package ru.job4j.shape;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing Paint.
 *
 * @author Kubar.
 * @since 04.10.2017.
 * @version 0.1.
 */
public class PaintTest {
    /**
     * Paint Triangle.
     */
    @Test
    public void whenPaintTriangleThenPaintTriangle() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String sep = System.getProperty("line.separator");
        System.setOut(new PrintStream(out));
        Paint paint = new Paint();
        paint.draw(new Triangle());
        assertThat(out.toString(), is("     +" + sep + "    +++" + sep + "   +++++" + sep + "  +++++++" + sep));
    }

    /**
     * Paint square.
     */
    @Test
    public void whenPaintSquareThenPaintSqare() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String sep = System.getProperty("line.separator");
        System.setOut(new PrintStream(out));
        Paint paint = new Paint();
        paint.draw(new Square());
        assertThat(out.toString(), is("++++++" + sep + "+    +" + sep + "+    +" + sep + "++++++" + sep));
    }
}