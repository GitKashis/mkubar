package ru.job4j.binaryTree;

import java.util.*;

public class BinaryTree<E extends Comparable<E>> implements Iterable<E> {

    /**
     * указатель на корень дерева.
     */
    private Node<E> root;

    /**
     * Переменная для подсчета количества узлов в дереве.
     * Необходима для корректной работы метода hasNext() в итераторе.
     */
    private int size;

    /**
     * Конструктор пустого дерева.
     */
    public BinaryTree() {
    }

    /**
     * Конструктор для создание дерева с корневым элементом.
     * @param value - корень дерева.
     */
    public BinaryTree(E value) {
        this.root = new Node<>(value);
    }


    /**
     * Добавление элемента в бинарное дерево.
     * Используются поля класса Node left, right.
     * Если добавляемый узел меньше родителя, то он сановится "левым", иначе - "правым".
     * Если дерево пустое, то первый элемент - корень.
     * @param e - элемент.
     */
    public void add(E e) {
        Node<E> node = new Node<>(e);

        if (root == null) {
            root = node;
        } else {
            Node<E> current = root;
            Node<E> parrent;

            while (true) {
                parrent = current;
                if (e.compareTo(current.value) < 0) {
                    current = current.left;
                    if (current == null) {
                        parrent.left = (node);
                        size++;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parrent.right = (node);
                        size++;
                        return;
                    }
                }
            }
        }
    }


    /**
     * Указывает текущую позицию итератора.
     */
    private Node<E> current;

    /**
     * Итератор БИНАРНОГО дерева.
     * Метод обхода: симметричный в глубину (in-order), итеративный с использованием стека.
     * При инициализации устанавливаем текущую позицию (current) в крайнее левое положение,
     * используя стек, поднимаемся до корня, затем просматриваем правую сторону дерева.
     */
    @Override
    public Iterator<E> iterator() {
        Deque<Node<E>> stack = new LinkedList<>();
        current = root;

        while (current.left != null) {
            stack.push(current);
            current = current.left;
        }

        return new Iterator<E>() {
            /**
             * временная переменная, используется только один раз
             * при выводе крайнего левого элемента.
             */
            private E tmp;
            /**
             * Переменная для подсчета количества пройденых элементов.
             */
            private int count = size;

            /**
             * @return true, если все элементы пройдены.
             */
            @Override
            public boolean hasNext() {
                return count != 0;
            }

            /**
             * @return возвращает значение E value текущего узла current.
             * Если при вызове метода все элементы уже пройдены,
             * генерирует исключение NoSuchElementException.
             */
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                if (current.right != null) {
                    current = current.right;

                    while (current.left != null) {
                        stack.push(current);
                        current = current.left;
                    }
                } else {
                    if (tmp == null) {
                        tmp = current.value;
                        return tmp;
                    }
                    current = stack.pop();
                }

                count--;
                return current.value;
            }
        };
    }
    /**
     * Базовый элемент-узел, служит для создания общего и бинарного деревьев.
     * @value children список для хранения "детей" дерева (может быть неограниченное количество).
     * @value left, right левые и правые узлы потомков БИНАРНОГО дерева.
     */
    class Node<E> {
        private E value;
        private Node<E> left;
        private Node<E> right;

        public Node(final E value) {
            this.value = value;
        }
    }
}