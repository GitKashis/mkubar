package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing CyclingCheck.
 *
 */
public class CyclingListCheckTest {
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


    /**
     * Круговой список
     */
    @Test
    public void whenNodeHasRoundCyclicThenReturnTrue() {
        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(first);

        boolean result = new CyclingListCheck<Node>().hasCycle(two);
        assertThat(result, is(true));
    }

    /**
     *           ┌ < ┐
     *           |    |
     * 1 -> 2 -> 3 -> 4
     */
    @Test
    public void whenNodeHasReverseLoopThenReturnTrue() {
        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(third);

        boolean result = new CyclingListCheck<Node>().hasCycle(first);
        assertThat(result, is(true));
    }

    /**
     *      ┌  <-   ┐
     *      |        |
     * 1 -> 2 -> 3 -> 4
     */
    @Test
    public void whenNodeHasLoopThenReturnTrue() {
        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(two);

        boolean result = new CyclingListCheck<Node>().hasCycle(first);
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

        boolean result = new CyclingListCheck<Node>().hasCycle(first);
        assertThat(result, is(false));
    }
}