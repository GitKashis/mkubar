package ru.job4j.list;

public class Node<T> {
    /**
     * Node value.
     */
    private T value;
    /**
     * Link to the next node.
     */
    private Node<T> next;

    /**
     * Node constructor.
     *
     * @param value - node value.
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * Set link to the next node.
     *
     * @param next - link to the next node.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Get link to the next node.
     *
     * @return Node.
     */
    public Node<T> getNext() {
        return next;
    }
}
