package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тестирование динамического массива
 * Created by Kubar on 08.10.2017.
 */
public class DynamicArrayTest {

    /**
     * Тестирование добавления и взятия элемента.
     */
    @Test
    public void add() throws Exception {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.add(10);
        array.add(20);
        array.add(30);

        int result = array.get(2);
        assertThat(result, is(30));
    }

    /**
     * Тестирование метода remove.
     */
    @Test
    public void remove() throws Exception {
        DynamicArray<Integer> array = new DynamicArray<>();

        array.add(10);
        array.add(20);
        array.add(30);

        array.remove(1);
        int result = array.get(1);
        assertThat(result, is(30));
    }

    /**
     * Тестирование размера массива.
     */
    @Test
    public void size() throws Exception {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.add(10);
        array.add(20);
        array.add(30);

        int result = array.size();
        assertThat(result, is(3));
    }

    /**
     * Тестирование метода next в итераторе.
     */
    @Test
    public void iteratorNext() throws Exception {
        DynamicArray<Integer> array = new DynamicArray<>();
        Iterator<Integer> itr = array.iterator();

        array.add(10);
        array.add(20);
        array.add(30);

        itr.next();
        int result = itr.next();
        assertThat(result, is(20));
    }

    /**
     * Тестирование метода hasNext в итераторе.
     */
    @Test
    public void iteratorHasNext() throws Exception {
        DynamicArray<Integer> array = new DynamicArray<>();
        Iterator<Integer> itr = array.iterator();

        array.add(10);
        array.add(20);

        itr.next();
        itr.next();
        boolean result = itr.hasNext();
        assertThat(result, is(false));
    }
}