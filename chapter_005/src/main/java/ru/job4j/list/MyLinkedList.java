package ru.job4j.list;

import java.util.Iterator;

/**
 * Реализация односвязного списка.
 * Created by Kubar on 09.10.2017.
 */
@SuppressWarnings("unchecked")
class MyLinkedList<T> implements Iterable<T> {
    // beginning of bag
    private Node<T> head;
    // ending of bag
    private Node<T> tail;
    // number of elements in bag
    private int count = 0;

    // Внутренний класс-контейнер.
    private class Node<T> {
        // объект хранения.
        private T item;
        //ссылка на следующий элемент.
        private Node<T> next;

        Node(T item) {
            this.item = item;
            this.next = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Node<?> node = (Node<?>) o;

            return item != null ? item.equals(node.item) : node.item == null;
        }

        @Override
        public int hashCode() {
            return item != null ? item.hashCode() : 0;
        }
    }

    /**
     * Создадим пустой список.
     */
    MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    /**
     * Is this bag empty?
     *
     * @return true if this bag is empty; false otherwise
     */
    boolean isEmpty() {
        return head == null;
    }

    /**
     * @return the number of items in this bag
     */
    int size() {
        return count;
    }

    /**
     * Если список не пуст, узел добавляется в конец списка,
     * а поле tail теперь указывает на новый конец списка.
     *
     * @param item the item to add to this bag
     */
    void add(T item) {

        //создаем новый контейнер для хранения item
        Node<T> newNode = new Node(item);

        //если было пусто, для добавленного контейнера ставим начало и конец.
        if (head == null) {
            head = newNode;
            tail = newNode;
        }

        // иначе добавляем в конец, тогда tail будет указывать не на null,
        // а на добавленый элемент.
        else {
            tail.next = newNode;
            // для самого списка обновляем хвост.
            tail = newNode;
        }
        count++;
    }

    /**
     * Метод пробегает по всему списку в поисках элемента с указанным индексом.
     *
     * @return <T> item.
     */
    T get(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }

        Node<T> check = head;

        for (int i = 0; i < index; i++) {
            check = check.next;
        }

        return check.item;
    }

    /**
     * Итератор односторонний
     *
     * @return Iterator
     */
    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private Node<T> thisNode = head;

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