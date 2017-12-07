package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NewSimpleHashSet<T> implements Iterable<T> {
    // начальный размер массива
    private final int INIT_SIZE = 16 ;

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
                objects[h] = null;
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
        return hash & (objects.length - 1);

    }

    /**
     * Iterator for simplearray.
     *
     * @return Iterator.
     */
    @Override
    public Iterator iterator() {

        T[] data = (T[]) this.objects;
        return new Iterator() {
            private int itr = 0;

            @Override
            public boolean hasNext() {
                return isContain(itr);
            }

            @Override
            public T next() {
                // если далее не обнаружено четных, то генерируем ошибку.
                if(!isContain(itr)) {
                    throw new NoSuchElementException();
                }
                // иначе возвращаем четное и идем дальше.
                return data[itr++];
            }

            private boolean isContain(int start) {
                boolean result = false;
                while (start < data.length) {
                    if (objects[itr] != null) {
                        result = true;
                        break;
                    }
                    start++;
                    itr++;
                }
                return result;
            }
        };
    }

    public int getSize() {
        return this.objects.length;
    }
}
