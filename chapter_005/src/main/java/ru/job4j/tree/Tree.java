package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

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
        Optional<Node<E>> nodeParent = findBy(parent);
        Optional<Node<E>> nodeChild = findBy(child);

        if (!nodeChild.isPresent() && nodeParent.isPresent())
            if (nodeParent.get().leaves().add(new Node<>(child))) {
                size++;
                return true;
            }
        return false;
    }

    /**
     * Добавление элемента в бинарное дерево.
     * Используются поля класса Node left, right.
     * Если добавляемый узел меньше родителя, то он сановится "левым", иначе - "правым".
     * Если дерево пустое, то первый элемент - корень.
     * @param e - элемент.
     */
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

        while (current.getLeft() != null) {
            stack.push(current);
            current = current.getLeft();
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

                if (current.getRight()!= null) {
                    current = current.getRight();

                    while (current.getLeft() != null) {
                        stack.push(current);
                        current = current.getLeft();
                    }
                }
                else {
                    if(tmp == null) {
                        tmp = current.getValue();
                        return tmp;
                    }
                    current = stack.pop();
                }

                count--;
                return current.getValue();
            }
        };
    }
}