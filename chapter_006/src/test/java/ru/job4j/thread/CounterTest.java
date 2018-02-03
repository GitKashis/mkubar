package ru.job4j.thread;

import org.junit.Test;

/**
 * Class for testing threads.
 *
 */
public class CounterTest {
    private String text = "The Java Virtual Machine allows an application to have " +
            "multiple threads of execution running concurrently";
    private Thread t1, t2;

    @Test
    public void analizeText() throws InterruptedException {
        System.out.println("Start analizing text");
        t1 = new Thread(new LetterCounter(text));
        t2 = new Thread(new SpacesCounter(text));

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        System.out.println("Finish analizing text");


    }

}