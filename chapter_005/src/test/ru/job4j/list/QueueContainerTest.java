package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class for testing QueueContainer.
 */
public class QueueContainerTest {
    /**
     * Test String poll.
     */
    @Test
    public void whenPollStringElementThenItReturn() {
        QueneContainer<String> queueContainer = new QueneContainer<>();
        queueContainer.push("A");
        queueContainer.push("B");
        queueContainer.push("C");
        queueContainer.poll();
        queueContainer.poll();
        String result = queueContainer.poll();
        assertThat(result, is("C"));
    }
}