package ru.job4j.tree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TreeTest {
    /**
     * Testing when add element.
     */
    @Test
    public void whenAddTheSameElementThenItDidNotAdd() {
        Tree<String> tree = new Tree<>("root");
        tree.add("root", "one");
        tree.add("root", "two");
        tree.add("two", "three");

        assertThat(tree.add("two", "three"), is(true));
    }
}