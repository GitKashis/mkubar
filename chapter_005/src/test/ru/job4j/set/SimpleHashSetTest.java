package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleHashSetTest {
    private SimpleHashSet simple;

    @Before
    public void setUp() {
        simple = new SimpleHashSet(5, 5);
    }

    /**
     * Duplicate elements.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenAddSameItemTurnWithoutThis() throws Exception {
        assertThat(simple.add(11), is(true));
        assertThat(simple.add(1), is(true));
        assertThat(simple.add(2), is(true));
        assertThat(simple.add(2), is(false));
        assertThat(simple.add(1), is(false));
    }

    /**
     * Remove elements.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenRemoveElement() throws Exception {
        simple.add(11);
        simple.add(1);
        simple.add(2);
        simple.add(2);
        simple.add(1);

        assertThat(simple.remove(11), is(true));
    }

    /**
     * Contains element.
     */
    @Test
    public void checkContainFunction() throws Exception {
        simple.add(11);
        simple.add(1);

        assertThat(simple.contains(11), is(true));
    }
}