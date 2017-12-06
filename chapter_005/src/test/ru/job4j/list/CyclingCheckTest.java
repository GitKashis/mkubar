package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing CyclingCheck.
 *
 */
public class CyclingCheckTest {
    /**
     * Testing when node has cyclical.
     */
    private Node first, two, third, four;

    @Before
    public void setUp() {
        first = new Node(1);
        two = new Node(2);
        third = new Node(3);
        four = new Node(4);
    }
    @Test
    public void whenNodeHasRoundCyclicThenReturnTrue() {
        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(first);

        boolean result = new CyclingCheck<Node>().hasCycle(two);
        assertThat(result, is(true));
    }

    @Test
    public void whenNodeHasLoopThenReturnTrue() {
        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(third);

        boolean result = new CyclingCheck<Node>().hasCycle(two);
        assertThat(result, is(true));
    }

    /**
     * Testing when node has not cyclical.
     */
    @Test
    public void whenNodeIsNotCyclicThenHasCycleReturnFalse() {
        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(null);

        boolean result = new CyclingCheck<Node>().hasCycle(first);
        assertThat(result, is(false));
    }
}