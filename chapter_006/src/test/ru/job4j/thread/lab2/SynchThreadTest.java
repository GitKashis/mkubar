package ru.job4j.thread.lab2;

import org.junit.Test;

/**
 *
 */
public class SynchThreadTest {

    final int NACCOUNTS = 100;
    final double INITIAL_BALANCE = 1000;
    final double MAX_AMOUNT = 1000;
    final int DELAY = 10;

    @Test
    public void whenThreadsAcessToSynchResource() throws InterruptedException {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);

        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;

            Thread t = new Thread(() -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep(DELAY);
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            t.start();
        }
        Thread.sleep(3000);
    }
}
