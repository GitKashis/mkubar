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

        simple.forEach(System.out::println);
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
        simple.forEach(System.out::println);
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
    public void testAbs() {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.abs(Integer.MIN_VALUE ));
        System.out.println(Math.abs(Integer.MIN_VALUE + 1));
    }
}