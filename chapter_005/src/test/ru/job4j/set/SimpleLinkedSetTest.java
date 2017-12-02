package ru.job4j.set;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleLinkedSetTest {
    private SimpleLinkedSet simple;

    @Before
    public void setUp() {
        simple = new SimpleLinkedSet();
    }

    /**
     * Duplicate elements.
     */
    @Test
    public void whenAddSameItemTurnWithoutThis() throws Exception {
        simple.add(0);
        simple.add(1);
        simple.add(2);
        simple.add(2);
        simple.add(1);

        assertThat(simple.size(), is(3));
    }

    /**
     * Iterator testing.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnPrimeNumbersOnly () {
        simple.add(0);
        simple.add(1);

        Iterator it = simple.iterator();

        assertThat(it.hasNext(), Matchers.is(true));
        it.next();
        it.next();
        assertThat(it.hasNext(), Matchers.is(false));

        it.next();
    }
}