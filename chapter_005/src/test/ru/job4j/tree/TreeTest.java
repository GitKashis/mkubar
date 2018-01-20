package ru.job4j.tree;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class TreeTest {
    private Tree<String> tree;
    private Iterator it;
    @Before
    public void setUp(){
        tree = new Tree<>("root");
        it = tree.iterator();
        }

    /**
     * Testing when add element.
     */
    @Test
    public void whenAddTheSameElementThenItDidNotAdd() {
        assertThat(tree.add("root", "one"), is(true));
        assertThat(tree.add("root", "two"), is(true));
        assertThat(tree.add("two", "three"), is(true));

        // попытка добавить существующий элемент
        assertThat(tree.add("three", "two"), is(false));
        // попытка добавить элемент к несуществующему родителю
        assertThat(tree.add("five", "four"), is(false));
    }

    /**
     * Testing iterator
     */
    @Test(expected = NoSuchElementException.class)
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation () {
        assertThat(it.next(), Matchers.is("root"));
        assertThat(it.next(), Matchers.is("one"));
        assertThat(it.next(), Matchers.is("two"));
        assertThat(it.next(), Matchers.is("three"));
        assertThat(it.next(), Matchers.is("four"));
        it.next();
    }
}