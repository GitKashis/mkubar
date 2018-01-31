package ru.job4j.simpleTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Базовый элемент-узел, служит для создания общего и бинарного деревьев.
 * @value children список для хранения "детей" дерева (может быть неограниченное количество).
 * @value left, right левые и правые узлы потомков БИНАРНОГО дерева.
 */
public class Node<E> {
    private final List<Node<E>> children = new ArrayList<>();
    private E value;
    private Node<E> left, right;

    public Node(final E value) {
        this.value = value;
    }

    public void add(Node<E> child) {
        this.children.add(child);
    }

    public List<Node<E>> leaves() {
        return this.children;
    }

    public boolean eqValue(E that) {
        return this.value.equals(that);
    }

    public E getValue() {
        return value;
    }
}

