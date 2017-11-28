package ru.job4j.list;


/**
 * Class for creating QueueContainer.
 */
public class QueneContainer<E> extends MyLinkedList<E> {
    /**
     * Add element to container.
     * @param value - value.
     */
    public void push(E value) {
        add(value);
    }

    /**
     * Get and remove first added element.
     * @return E - element.
     */
    public E poll() {
        Integer index = new Integer(0);
        E result = get(index);
        this.remove(index);
        return result;
    }
}