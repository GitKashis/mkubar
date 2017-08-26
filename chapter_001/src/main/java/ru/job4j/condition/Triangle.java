package ru.job4j.condition;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Class Triangle Решение задачи. Часть 001, урок 3.3.
 * @author Mikhail Kubar
 * @since 26.08.2017
 */
public class Triangle {

    /**
     * Point a.
     */
    private Point a;
    /**
     * Point b.
     */
    private Point b;
    /**
     * Point c.
     */
    private Point c;

    /**
     * Constructor.
     * @param a is pointA (x, y).
     * @param b is pointB (x, y).
     * @param c is pointC (x, y).
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод должен вычислять расстояние между точками left и right.
     *
     * Для вычисления расстояния использовать формулу.
     * √(xb - xa)^2 + (yb - ya)^2
     *
     * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
     *
     * ^ - степень.
     *
     * @param left Точка слева
     * @param right Точка с права.
     * @return расстояние между точками left и right.
     */
    public double distance(Point left, Point right) {
        return sqrt(
                pow((right.getX() - left.getX()), 2)
                        + pow((right.getY() - left.getY()), 2));
    }

    /**
     * Метод вычисления периметра по длинам сторон.
     *
     * Формула.
     *
     * (ab + ac + bc)
     *
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return Периметр.
     */
    public double perimetr(double ab, double ac, double bc) {
        return (ab + ac + bc);
    }

    /**
     * Метод должен вычислить прощадь треугольканива.
     *
     * Формула.
     *
     * √ p *(p - ab) * (p - ac) * (p - bc)
     *
     * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
     *
     * @return Вернуть прощадь, если треугольник существует или -1.
     */
    public double area() {
        double rsl = -1;
        double ab = this.distance(this.a, this.b);
        double ac = this.distance(this.a, this.c);
        double bc = this.distance(this.b, this.c);
        double p = this.perimetr(ab, ac, bc) / 2; // полупериметр.
        if (this.exist(ab, ac, bc)) {
            // написать формулу для расчета площади треугольника.
            rsl = sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * Условие существование треугольника.
     * Для существования треугольника со сторонами a,b,c необходимо и достаточно выполнения трех неравентсв.
     *
     * Вырожденным называется треугольник, площадь которого равна нулю.
     *
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     * @return существование треугольника.
     */
    private boolean exist(double ab, double ac, double bc) {
        return (ab <= bc + ac) && (bc <= ab + ac) && (ac <= ab + bc);
    }
}
