package ru.job4j.list;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing StackContainer.
 */
public class StackContainerTest {
    /**
     * Test String poll.
     */
    @Test
    public void whenAdd() {
        SimpleStack<String> stackContainer = new SimpleStack<>();
        stackContainer.push("A");
        stackContainer.push("B");
        stackContainer.push("C");

        assertThat(stackContainer.poll(), is("C"));
        assertThat(stackContainer.poll(), is("B"));
        assertThat(stackContainer.poll(), is("A"));
    }
}
