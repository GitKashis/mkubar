package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;


import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование SimpleHashTable.
 *
 * @author mkubar.
 * @version 0.1.
 * @since 09.01.2018.
 */
public class SimpleHashTableTest {

    private SimpleHashTable<String, Integer> table;

    @Before
    public void setUp() {
        table = new SimpleHashTable<>();
        table.insert("Page", 33);
        table.insert("Book", 54);
        table.insert("Image", 11);
    }

    /**
     * Testing insert element into HashTable collection.
     */
    @Test
    public void whenPutNewElementIntoHashTableThenItAddInIt() {

        int result = table.get("Image");
        assertThat(result, is(11));
    }

    /**
     * Testing delete element from HashTable collection.
     */
    @Test
    public void whenDeleteElementIntoHashTableThenItAddInDelete() {
        boolean result = table.delete("Image");
        assertThat(result, is(true));
    }

    /**
     * Testing iterator.
     */
    @Test
    public void whenGetElementByIteratorThenItGet() {
        String result = null;
        for (Object aTable : table) {
            if (aTable.equals(11)) {
                result = "Yes";
            }
        }
        assertThat(result, is("Yes"));
    }

    /**
     * Testing insert same elements into HashTable collection.
     */
    @Test
    public void whenPutFewSameElementIntoHashTableThenAddJustOne() {
        table.insert("Image", 55);

        int result = table.get("Image");
        assertThat(result, is(55));
    }

    /**
     * Testing insert same elements into HashTable collection.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenAddThreeElementsAndCallHasNextThenOnFourAttemptReturnFalse() {

        table.iterator().next();    // value 1
        table.iterator().next();    // value 2
        table.iterator().next();    // value 3

        table.iterator().hasNext();     // false
        table.iterator().next();    // no elements

        assertThat(table.iterator().hasNext(), is(false));
    }
}