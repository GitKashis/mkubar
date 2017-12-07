package ru.job4j.list;

/**
 * Class for CyclingList check.
 *
 * @param <T> - value
 */
public class CyclingCheck<T> {
    /**
     * Check cyclical Node.
     */
    public boolean hasCycle(Node<T> head) {
        if (head == null) return false;

        Node fast = head.getNext();
        Node slow = head;

        while (fast != null && fast.getNext() !=  null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return false;
    }
}