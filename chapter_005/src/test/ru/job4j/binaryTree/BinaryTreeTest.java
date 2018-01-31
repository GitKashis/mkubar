package ru.job4j.binaryTree;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BinaryTreeTest {

    /**
     * Бинарное дерево с числовыми элементами.
     * Тестирование добавления элементов.
     * Тестирование итератора симметричного обхода, вывод элементов в порядке возрастания.
     * Проверка на исключение NoSuchElementException
     */
    @Test(expected = NoSuchElementException.class)
    public void whenAddIntegerElementsAtTreeThenTheyAdded() {
        BinaryTree<Integer> binary = new BinaryTree<>();

        binary.add(3);
        binary.add(16);
        binary.add(4);
        binary.add(6);
        binary.add(2);
        binary.add(11);
        binary.add(14);
        binary.add(8);

        Iterator<Integer> itr = binary.iterator();

        assertThat(itr.next(), is(2));
        assertThat(itr.next(), is(3));
        assertThat(itr.next(), is(4));
        assertThat(itr.next(), is(6));
        assertThat(itr.next(), is(8));
        assertThat(itr.next(), is(11));
        assertThat(itr.next(), is(14));
        assertThat(itr.next(), is(16));

        binary.forEach(System.out::println);
        itr.next();
    }

}