package ru.job4j.thread.threadSafe;

import ru.job4j.list.MyLinkedList;

import java.util.Iterator;

public class ThreadSafeList<T> extends MyLinkedList<T> {

    @Override
    public synchronized void add(T item) {
        super.add(item);
    }

    @Override
    public synchronized T get(int index) {
        return super.get(index);
    }

    @Override
    public synchronized boolean remove (int index) {
        return super.remove(index);
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return super.iterator();
    }

    @Override
    public synchronized int size() {
        return super.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return super.isEmpty();
    }
}
