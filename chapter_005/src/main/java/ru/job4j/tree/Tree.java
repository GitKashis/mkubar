package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;

    public Tree(E rootData) {
        root = new Node<>(rootData);
    }

    /**
     * Check that this collection is binary.
     * @return boolean.
     */
    public boolean isBinary() {
        return getAround(root);
    }

    /**
     * Get around this collection and check that each parent has not more 2 children.
     * @param root - start position for check.
     * @return boolean.
     */
    private boolean getAround(Node<E> root) {
        boolean result = true;
        List<Node<E>> children = root.leaves();
        if (children.size() > 0 && children.size() < 3 || children.size() == 0) {
            for (Node<E> node : root.leaves()) {
                result = getAround(node);
                if (!result) {
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;
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

    public void add(E e){
        Node<E> currentNode = root, emptyNode = null;
        while (currentNode != null) {
            int cmp = e.compareTo(currentNode.getValue());
            if (cmp == 0) {
                currentNode.setValue(e);
            } else {
                emptyNode = currentNode;
                if (cmp < 0) {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }

        Node<E> newNode = new Node<>(e);
        if (emptyNode == null) {
            root = newNode;
        } else {
            if (e.compareTo(emptyNode.getValue()) < 0) {
                emptyNode.left = newNode;
            } else {
                emptyNode.right = newNode;
            }
        }
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

