package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NewSimpleHashSet<T> implements Iterable<T> {
    // начальный размер массива
    private final int INIT_SIZE = 100 ;

    private Object[] objects = new Object[INIT_SIZE];
    // количество элементов
    private int cnt = 0;

    /*
     * Добавляет элемент в множество
     */
    public boolean add(T x) {
        if (this.contains(x))
            return false;
        int h = index(hash(x));
        objects[h] = x;
        return true;
    }

    /*
     * Проверяет, содержится ли x в множестве
     */
    public boolean contains(T x) {
        int h = index(hash(x));
        return objects[h] != null && objects[h].equals(x);
    }

    public boolean remove(T item) {
        int h = index(hash(item));
        if (objects[h].equals(item)) {
                System.arraycopy(objects, h + 1, objects, h, objects.length - h - 1);
                objects[cnt] = null;
                this.cnt--;
                return true;
            }
        return false;
    }

    /*
     * хэш-функция (для других типов следует изменить)
     */
    private int hash(T x) {
        return x.hashCode();
    }

    /* возвращает номер ячейки по значению хэш-функции */
    private int index(int hash) {
        return Math.abs(hash) % objects.length;
    }

    /**
     * Iterator for simplearray.
     *
     * @return Iterator.
     */
    @Override
    public Iterator iterator() {
        //
        int count = this.objects.length;
        Object[] data = this.objects;

        return new Iterator() {
            private int itr = 0;

            @Override
            public boolean hasNext() {
                return count > itr;
            }

            @Override
            public T next() {

                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) data[itr++];
            }
        };
    }

    public int getSize() {
        return this.objects.length;
    }
}
