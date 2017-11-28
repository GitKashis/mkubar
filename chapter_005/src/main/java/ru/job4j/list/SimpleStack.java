package ru.job4j.list;

/**
 * Class for creating SimpleStack.
 *
 * @param <E> - type of element.
 */
public class SimpleStack<E> extends MyLinkedList<E> {
    /**
     * Add element to container.
     * @param value - value.
     */
    public void push(E value) {
        add(value);
    }

    /**
     * Get and remove last added element.
     * @return E - element.
     */
    public E poll() {
        Integer index = new Integer(size() - 1);
        E result = get(index);
        this.remove(index);
        return result;
    }
}