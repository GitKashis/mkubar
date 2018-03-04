package ru.job4j.thread;


import org.junit.Test;
import ru.job4j.count.LettersCount;
import ru.job4j.count.SpacesCount;

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
        t1 = new Thread(new LettersCount(text), "t1");
        t2 = new Thread(new SpacesCount(text), "t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Finish analizing text");
    }
}

        
                