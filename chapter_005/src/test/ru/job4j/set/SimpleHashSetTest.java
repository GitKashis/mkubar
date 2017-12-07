package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleHashSetTest {
    private NewSimpleHashSet simple;

    @Before
    public void setUp() {
        simple = new NewSimpleHashSet();
    }

    /**
     * Duplicate elements.
     */
    @Test
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
    @Test
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

    @Test
    public void IntegerTest() {
        Integer i = 50;
        Integer z = new Integer(50);
        Integer y = 50;
        System.out.println("i " + System.identityHashCode(i));
        System.out.println("z " + System.identityHashCode(z));
        System.out.println("y " + System.identityHashCode(y));
        System.out.println("i == z " + (i == z));
        System.out.println("i == y " + (i == y));
    }
}