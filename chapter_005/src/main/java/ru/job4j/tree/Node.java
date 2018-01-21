package ru.job4j.tree;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Node<E> {
    private final List<Node<E>> children = new ArrayList<>();
    private E value;
    protected Node<E> left, right;

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

    public void setValue(E e) {
        this.value = e;
    }
}
