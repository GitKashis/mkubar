package ru.job4j.thread;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class CounterTest {
    private Counter counter;
    private String text = "A thread is a thread of execution in a program. The Java Virtual Machine allows an application to have multiple threads of execution running concurrently.";

    @Before
    public void setUp() {
        counter = new Counter(text);
    }

    @Test
    public void getSpaces() {
        System.out.println(counter.getSpaces());
    }

    @Test
    public void getLetters() {
        System.out.println(counter.getLetters());
    }
}