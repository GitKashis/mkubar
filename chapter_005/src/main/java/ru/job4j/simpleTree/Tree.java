package ru.job4j.simpleTree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    /**
     * указатель на корень дерева.
     */
    private Node<E> root;

    /**
     * Конструктор пустого дерева.
     */
    public Tree() {
    }

    /**
     * Конструктор для создание дерева с корневым элементом.
     * @param value - корень дерева.
     */
    public Tree(E value) {
        this.root = new Node<>(value);
    }

    /**
     * Проверка дерева на бинарность.
     *
     * @return boolean.
     */
    public boolean isBinary() {
        boolean rsl = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.leaves().size() > 2) {
                rsl = false;
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * Берем очередь и добавляем первый элемент дерева - это корень.
     * Дальше, если корень не наш элемент мы добавляем все элементы корня.
     * И так для каждого элемента.
     * @param  value - key.
     * @return Node<E> or empty.
     */
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
     * Проверяем, есть ли уже такой элемент child в коллекции.
     * Если такого нет, то ищем родителя parent, к которому нужно прицепить этот child
     * После успешного добавления увеличиваем счетчик элементов.
     *
     * @param parent parent.
     * @param child  child.
     * @return true, если добавление произошло.
     */
    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> aParent = findBy(parent);
        Optional<Node<E>> aChild = findBy(child);

        if (!aChild.isPresent() && aParent.isPresent()) {
            if (aParent.get().leaves().add(new Node<>(child))) {
               return true;
            }
        }
        return false;
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