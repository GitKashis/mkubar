package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashSet<T> implements Iterable<T> {
    int[] head; // массив голов
    int[] next; // массив ссылок на следующий элемент
    T[] keys; // массив с ключами (вместо int'а следует поставить нужный тип)
    int headNum; // количество голов
    int cnt = 1; // ссылка на место для вставки нового эдемента

    /* Конструктор */
    SimpleHashSet(int headNum, int maxSize) {
        this.headNum = headNum;
        head = new int[headNum];
        next = new int[maxSize + 1];
        keys = (T[]) new Object[maxSize + 1];
    }

    /*
     * Добавляет элемент в множество
     */
    public boolean add(T x) {
        if (this.contains(x))
            return false;
        int h = index(hash(x));
        next[cnt] = head[h];
        keys[cnt] = x;
        head[h] = cnt++;
        return true;
    }

    /*
     * Проверяет, содержится ли x в множестве
     */
    public boolean contains(T x) {
        int h = index(hash(x));
        for (int i = head[h]; i != 0; i = next[i])
            if (keys[i] == x)
                return true;
        return false;
    }

    public boolean remove(T item) {
        int h = index(hash(item));
        for (int i = head[h]; i != 0; i = next[i]) {
            if (keys[i] == item) {
                System.arraycopy(keys, i + 1, keys, i, cnt - i);
                keys[cnt] = null;
                this.cnt--;
                return true;
            }
        }
        return false;
    }

    /*
     * хэш-функция (для других типов следует изменить)
     */
    private int hash(T x) {
        return x.hashCode();
    }

    /* возвращает номер головы по значению хэш-функции */
    private int index(int hash) {
        return Math.abs(hash) % headNum;
    }


    /**
     * Iterator for simplearray.
     *
     * @return Iterator.
     */
    @Override
    public Iterator iterator() {
        //
        int count = this.headNum;
        T[] data = this.keys;

        return new Iterator() {
            private int itr = 0;

            @Override
            public boolean hasNext() {
                return count > itr;
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
                    if (keys[itr] != null) {
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
        return this.keys.length;
    }
}
