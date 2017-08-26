package ru.job4j.condition;

import static org.hamcrest.number.IsCloseTo.closeTo;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Mikhail Kubar.
 * @version 1.0.
 * @since 26.08.2017.
 */
public class TriangleTest {
    /**
     *  создаем три объекта класса Point.
     */
    private Point a = new Point(0, 0);

    /**
     * Point b.
     */
    private Point b = new Point(0, 3);
    /**
     * Point c.
     */
    private Point c = new Point(4, 0);
    /**
     *  Создаем объект треугольник и передаем в него объекты точек.
     */
    private Triangle triangle = new Triangle(a, b, c);

    /**
     * Test length.
     */
    @Test
    public void distance() {
        // Вычисляем длину.
        double result = triangle.distance(a, b);
        // Задаем ожидаемый результат.
        double expected = 3D;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }
    /**
     * Test avoid.
     */
    @Test
    public void perimetr() {
        // Вычисляем периметр.
        double result = triangle.perimetr(
                triangle.distance(a, b),
                triangle.distance(b, c),
                triangle.distance(a, c));
        // Задаем ожидаемый результат.
        double expected = 12D;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }

    /**
     * Test area.
     */
    @Test
    public void area() {
        // Вычисляем площадь.
        double result = triangle.area();
        // Задаем ожидаемый результат.
        double expected = 6D;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 6));
    }
}
