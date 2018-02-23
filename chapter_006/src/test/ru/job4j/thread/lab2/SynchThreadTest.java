package ru.job4j.thread.lab2;

import org.junit.Before;
import org.junit.Test;

public class SynchThreadTest {

 public final int NACCOUNTS = 100;
 public final double INITIAL_BALANCE = 1000;
 public final double MAX_AMOUNT = 1000;
 public final int DELAY = 10;



    @Test
    public void whenThreadsAcessToSynchResource() {
        SynchBank bank = new SynchBank(NACCOUNTS, INITIAL_BALANCE);

        for (int i = 0; i < NACCOUNTS; i++)
        {
            int fromAccount = i;
            Runnable r = () -> {
                try
                {
                    while (true)
                    {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                }
                catch (InterruptedException e) {
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
