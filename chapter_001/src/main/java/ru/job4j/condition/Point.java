package ru.job4j.condition;

/**
 * Class Point Решение задачи. Часть 001, урок 3.2.
 * @author Mikhail Kubar
 * @since 26.08.2017
 */
public class Point {
    /**
     * @param x is coordinate.
     */
    private int x;
    /**
     * @param y is coordinate.
     */
    private int y;

    /**
     * Constructor.
     * @param x is coordinate.
     * @param y is coordinate.
     */
    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * @return возвращает коорд. по X.
     */
    public int getX() {
        return this.x;
    }
    /**
     * @return возвращает коорд. по Y.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Метод проверяет, принадлежит ли точка point (x, y)
     * функции вида y(x) = a*x + b.
     * @param a - коэффициент при X.
     * @param b - свободный коэффициент.
     * @return false or true.
     */
    public boolean is(int a, int b) {
        return (this.y == (a * this.x + b));
    }
}
