package ru.job4j.list;

/**
 * Class for CyclingList check.
 *
 * @param <T> - value
 */
public class CyclingCheck<T> {
    /**
     * Check cyclical Node.
     *
     * @param first - start element.
     * @return boolean.
     */
    public boolean hasCycle(Node<T> first) {
        Node<T> next = first.getNext();

        while (next.getNext() != null) {
            if (next.getNext().equals(first.getNext())) {
                return true;
            } else {
                next = next.getNext();
            }
        }
        return false;
    }
}