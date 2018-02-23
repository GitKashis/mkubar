package ru.job4j.thread.lab2;

import java.util.Arrays;

public class SynchBank {
    private final double[] accounts;

    /**
     * Конструирует объект банка
     * @param n Количество счетов
     * @param initialBalance Первоначальный остаток на каждом счете
     */
    public SynchBank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * Переводит деньги с одного счета на другой
     * @param from Счет, с которого переводятся деньги
     * @param to Счет, на который переводятся деньги
     * @param amount Сумма перевода
     */
    public synchronized void transfer(int from, int to, double amount)
            throws InterruptedException {
        while (accounts[from] < amount) {
            this.wait();
        }
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %.f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %.f%n", this.getTotalBalance());
        this.notifyAll();
    }

    /**
     * Получает сумму остатков на всех счетах
     * return Возвращает общий баланс
     */
    public synchronized double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }

    /**
     * Получает сумму остатков на всех счетах
     * return Возвращает общий баланс
     */
    public int size () {
        return accounts.length;
    }
}
