package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;

    public Tree(E rootData) {
        root = new Node<>(rootData);
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

    /**
     * Метод добавляет в коолекцию элемент, если его еще не было.
     * @param parent parent.
     * @param child  child.
     * @return true, если добавление произошло.
     */
    @Override
    public boolean add(E parent, E child) {
        // ищем элементы в коллекции.
        Optional<Node<E>> nodeParent = findBy(parent);
        Optional<Node<E>> nodeChild = findBy(child);
        // проверяем, есть ли уже такой элемент child в коллекции.
        // если такого нет, то ищем родителя parent, к которому нужно прицепить этот child
        return (!nodeChild.isPresent() && nodeParent.isPresent())
                    && nodeParent.get().leaves().add(new Node<>(child));
    }

    /**
     * Итератор обхода в ширину.
     * Инициализируем корневым элементом.
     */
    @Override
    public Iterator<E> iterator() {
        Queue<Node<E>> data = new LinkedList<>();
        data.add(root);

        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return data.isEmpty();
            }

            @Override
            public E next() {
                if (hasNext())
                    throw new NoSuchElementException();

                Node<E> current = data.poll();
                if (!current.leaves().isEmpty()) {
                    data.addAll(current.leaves());
                }
                return current.getValue();
            }
        };
    }
}

