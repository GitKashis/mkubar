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
     * @param  - start element.
     * @return boolean.
     */
    public boolean hasCycle(Node<T> next) {
        // сохраняем точку входя для проверки на круговой список
        Node start = next;
        // запоминаем предыдущий элемент
        Node prev = start;

        while (next.getNext() != null) {
            if ((next.getNext().equals(prev))||(next.getNext().equals(start))) {
                return true;
            }
            else {
                prev = next;
                next = next.getNext();
            }
        }
        return false;
    }
}