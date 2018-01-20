package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E>, Comparator<E> {
    private Node<E> root;

    public Tree(E rootData) {
        root = new Node<E>(rootData);
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public boolean add(E parent, E child) {
        Node<E> node = findBy(parent).get();
        return node.leaves().add(new Node<E>(child));

    }

    @Override
    public int compare(E o1, E o2) {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
