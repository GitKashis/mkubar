package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int size;
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
        if (!nodeChild.isPresent() && nodeParent.isPresent())
            if (nodeParent.get().leaves().add(new Node<>(child))) {
            size++;
            return true;
        }
        return false;
    }

    public void add(E e){
        Node<E> newNode = new Node<>(e);

        if (root == null) {
            root = newNode;
        }
        else {
            Node<E> current = root;
            Node<E> parrent;

            while(true) {
                parrent = current;
                if(e.compareTo(current.getValue()) < 0) {
                    current = current.getLeft();
                    if(current == null){
                        parrent.setLeft(newNode);
                        size++;
                        return;
                    }
                }
                else {
                    current = current.getRight();
                    if(current == null){
                        parrent.setRight(newNode);
                        size++;
                        return;
                    }
                }
            }
        }
    }

    private Node<E> current;
    @Override
    public Iterator<E> iterator() {
        Deque<Node<E>> nodeStack = new LinkedList<>();
        current = root;

        while (current.getLeft() != null) {
            nodeStack.push(current);
            current = current.getLeft();
        }

        return new Iterator<E>() {
        private E tmp;
        @Override
            public boolean hasNext() {
                return size != 0;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                if (current.getRight()!= null) {
                    current = current.getRight();

                    while (current.getLeft() != null) {
                        nodeStack.push(current);
                        current = current.getLeft();
                    }

                }
                else {
                        if(tmp == null) {
                            tmp = current.getValue();
                            return tmp;
                        }
                        current = nodeStack.pop();
                }

                size--;
                return current.getValue();
            }
        };
    }
}

