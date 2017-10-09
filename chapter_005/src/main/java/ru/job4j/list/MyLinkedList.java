package ru.job4j.list;

import java.util.Iterator;

/**
 * Реализация связного списка.
 * Created by Kubar on 09.10.2017.
 */
@SuppressWarnings("unchecked")
class MyLinkedList<T> implements Iterable<T>{
    // beginning of bag
    private Node<T> first;
    // number of elements in bag
    private int n = 0;

    // helper linked list class
    private class Node<T> {
        private T item;
        private Node<T> next;

    }

    /**
     * Initializes an empty bag.
     */
    MyLinkedList() {
        first = null;
        n = 0;
    }

    /**
     * Is this bag empty?
     *
     * @return true if this bag is empty; false otherwise
     */
    boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this bag.
     *
     * @return the number of items in this bag
     */
    int size() {
        return n;
    }

    /**
     * Новый контейнер добавляется с головы списка.
     *
     * @param item the item to add to this bag
     */
    void add(T item) {
        Node<T> oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    /**
     * Get item to index.
     *
     * @param getIndex
     * @return T item of this bag.
     */
    T get(int getIndex){
        Node tempp = first;
        for (int i = 0; i < getIndex; ++i)
            tempp = tempp.next;
        return (T) tempp.item;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private Node<T> thisNode = first;
            @Override
            public boolean hasNext() {
                return thisNode != null;
            }

            @Override
            public T next() {
                T value = thisNode.item;
                thisNode = thisNode.next;
                return value;

            }
        };
    }

}