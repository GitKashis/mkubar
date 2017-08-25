package ru.job4j.calculator;
/**
 * Class Calculate Решение задачи. Часть 001, урок 2.3
 * @author Mikhail Kubar
 * @since 25.08.2017
 */
public class Calculator {

    /**
     * @param result - результат вычисления.
     */
    private double result;

    /**
     * Сложение.
     * @param first - первое число.
     * @param second - второе.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Выяитание.
     * @param first - первое число.
     * @param second - второе.
     */
    public void substruct(double first, double second) {
        this.result = first - second;
    }

    /**
     * @param first - первое число.
     * @param second - второе.
     * Деление.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * @param first - первое число.
     * @param second - второе.
     * Умножение.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Метод получения результата вычисления.
     * @return - возвращает результат.
     */
    public double getResult() {
        return this.result;
    }
}