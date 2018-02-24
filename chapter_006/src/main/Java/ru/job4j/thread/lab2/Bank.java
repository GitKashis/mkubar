package ru.job4j.thread.lab2;

import java.util.Arrays;

public class Bank {
    private final double[] accounts;

    /**
     * Конструирует объект банка.
     * @param n Количество счетов.
     * @param initialBalance Первоначальный остаток на каждом счете.
     */
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * Переводит деньги с одного счета на другой.
     * @param from Счет, с которого переводятся деньги.
     * @param to Счет, на который переводятся деньги.
     * @param amount Сумма перевода.
     */
    public synchronized void transfer(int from, int to, double amount)
            throws InterruptedException {
        while (accounts[from] < amount) {
            this.wait(); // ожидать по единственному условию
                         // встроенной блокировки объектов
        }
        accounts[from] -= amount;
        accounts[to] += amount;

        System.out.printf("%-10s %-8.2f from %-3d to %-3d Total balance: %10.2f%n",
                Thread.currentThread().getName(), amount, from, to, this.getTotalBalance());

        this.notifyAll(); // уведомить все потоки,
                          // ожидающие по данному условию
    }

    /**
     * Получает сумму остатков на всех счетах.
     * return Возвращает общий баланс.
     */
    public synchronized double getTotalBalance() {
        return Arrays.stream(accounts).sum();
    }

    /**
     * Получает сумму остатков на всех счетах.
     * return Возвращает общий баланс.
     */
    public int size () {
        return accounts.length;
    }
}
