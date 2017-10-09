package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тестирование списка MyLinkedLis.
 * Created by Kubar on 09.10.2017.
 */
public class MyLinkedListTest {

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
     * Тести разерности списка.
     */
    @Test
    public void size() throws Exception {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("first");
        list.add("second");
        list.add("last");

        int result = list.size();
        assertThat(result, is(3));
    }

    /**
     * Тестирование добавления и считывания элементов.
     * Обход начинается с головы списка, т.е с элемента,
     * который зашел последним. Реализуется последовательность FILO.
     */
    @Test
    public void add() throws Exception {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("first");
        list.add("second");
        list.add("last");

        String result = list.get(0);
        assertThat(result, is("last"));
    }

    @Test
    public void iteratorHasNext() throws Exception {
        MyLinkedList<String> list = new MyLinkedList<>();
        Iterator<String> itr = list.iterator();

        list.add("first");
        list.add("second");

        boolean result = itr.hasNext();
        assertThat(result, is(false));
    }

}