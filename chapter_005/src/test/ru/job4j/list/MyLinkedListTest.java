package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тестирование списка MyLinkedLis.
 * Created by Kubar on 09.10.2017.
 */
public class MyLinkedListTest {
    private MyLinkedList<String> list;

    @Before
    public void setUp() {

        list =new MyLinkedList<>();

        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
    }

    /**
     * Пустым может быть в начале при инициализации,
     * либо после удаления всех контейнеров.
     */
    @Test
    public void isEmpty() throws Exception {
        MyLinkedList<String> list = new MyLinkedList<>();

        boolean result = list.isEmpty();
        assertThat(result, is(true));
    }

    /**
     * Тести размерности списка.
     */
    @Test
    public void size() throws Exception {
        int result = list.size();
        assertThat(result, is(3));
    }

    /**
     * Тестирование добавления и считывания элементов.
     * Обход начинается с головы списка, т.е с элемента,
     * который зашел первым. Реализуется последовательность FIFO.
     */
    @Test
    public void add() throws Exception {

        String result = list.get(2);
        assertThat(result, is("last"));
    }

    /**
     * После второго должен вернуть false
     */
    @Test
    public void iteratorHasNext() throws Exception {
        Iterator<String> itr = list.iterator();

        itr.next();
        itr.next();
        itr.next();

        boolean result = itr.hasNext();
        assertThat(result, is(false));
    }

    /**
     * после второго должен вернуть second
     */
    @Test
    public void iteratorNext() throws Exception {

        Iterator<String> itr = list.iterator();
        itr.next();

        String result = itr.next();
        assertThat(result, is("second"));
    }

    /**
     * Тестирование удаления элемента по индексу
     */
    @Test
    public void removeFirst() {
        assertThat(list.remove(0), is(true));
        assertThat(list.remove(1), is(true));
    }
}