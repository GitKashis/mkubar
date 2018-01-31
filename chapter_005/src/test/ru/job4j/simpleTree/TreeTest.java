package ru.job4j.simpleTree;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TreeTest {
    private Tree<String> tree;
    private Iterator<String> it;
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
        tree.add("root", "one");
        tree.add("root", "two");
        tree.add("two", "three");
        tree.add("two", "four");

        assertThat(it.next(), Matchers.is("root"));
        assertThat(it.next(), Matchers.is("one"));
        assertThat(it.next(), Matchers.is("two"));
        assertThat(it.next(), Matchers.is("three"));
        assertThat(it.next(), Matchers.is("four"));
        it.next();
    }

    /**
     * Testing binary.
     */
    @Test
    public void whenCheckThatTreeIsBinaryThenReturnFalse() {
        tree.add("root", "one");
        tree.add("root", "two");
        tree.add("two", "three");
        tree.add("two", "four");
        tree.add("two", "five");

        boolean result = tree.isBinary();
        assertThat(result, is(false));
    }
    /**
     * Testing binary.
     */
    @Test
    public void whenCheckThatTreeIsBinaryThenReturnTrue() {
        tree.add("root", "one");
        tree.add("root", "two");
        tree.add("one", "three");
        tree.add("one", "four");
        tree.add("two", "five");
        tree.add("two", "six");

        boolean result = tree.isBinary();
        assertThat(result, is(true));
    }

    /**
     * Testing binary.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenAddStringElementsAtTreeThenTheyAdded() {
        tree.add("root", "one");
        tree.add("root", "two");
        tree.add("one", "three");
        tree.add("one", "four");
        tree.add("two", "five");
        tree.add("two", "six");

        assertThat(it.next(), Matchers.is("root"));
        assertThat(it.next(), Matchers.is("one"));
        assertThat(it.next(), Matchers.is("two"));
        assertThat(it.next(), Matchers.is("three"));
        assertThat(it.next(), Matchers.is("four"));
        assertThat(it.next(), Matchers.is("five"));
        assertThat(it.next(), Matchers.is("six"));
        it.next();
    }
}