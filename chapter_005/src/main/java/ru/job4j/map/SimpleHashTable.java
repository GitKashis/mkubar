package ru.job4j.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализация собственной структуры данных - HashMap.
 *
 * @author mkubar.
 * @version 0.1.
 * @since 09.01.2018.
 * @param <K> - key.
 * @param <V> - value.
 */
public class SimpleHashTable<K, V> implements Iterable {
    /**
     * Массив контейнеров, содержащих пару ключ-значение.
     */
    private Container<K, V>[] table;

    /**
     * Количество добавленных элементов.
     */
    private int size = 0;

    /**
     * Конструктор хэш-таблицы. Размер по умолчанию - 16;
     */
    public SimpleHashTable() {
        table = new Container[16];
    }

    /**
     * Загрузка контейнера с парой ключ-значение.
     * @param key - key.
     * @param value - value.
     * @return true - если добавлено успешно.
     */
    public boolean insert(K key, V value) {
        int position;
        boolean result;

        if (key == null) {
            return false;
        }

        if (size > table.length - 1) {
            resizeTable();
        }

        position = getPosition(key, table.length);

        if (table[position] != null && table[position].getContainerKey().equals(key)) {
            table[position].setContainerValue(value);
            result = true;
        } else if (table[position] != null && !table[position].getContainerKey().equals(key)) {
            result = false;
        } else {
            table[position] = new Container<>(key, value);
            size++;
            result = true;
        }
        return result;
    }

    /**
     * Возврат значения по ключу.
     * @param key - key.
     * @return V - value.
     */
    public V get(K key) {
        if (table[getPosition(key, table.length)].getContainerValue() != null) {
            return table[getPosition(key, table.length)].getContainerValue();
        } else {
            throw new NoSuchElementException();
        }

    }

    /**
     * Удаление элемента из таблицы по ключу.
     * @param key - key.
     * @return true - если был успешно удален.
     */
    public boolean delete(K key) {
        boolean result = false;
        if (table[getPosition(key, table.length)] != null) {
            table[getPosition(key, table.length)] = null;
            size--;
            result = true;
        }
        return result;
    }

    /**
     * Увеличение массива, если таблица заполнена.
     */
    private void resizeTable() {
        Container[] newTable = new Container[table.length * 2];
        copyOldTable(newTable);
    }

    /**
     * Копируем элементы в новую таблицу.
     * @param newTable - table.
     */
    private  void copyOldTable(Container<K, V>[] newTable) {
        int newPosition;
        for (Container element : table) {
            newPosition = getPosition((K) element.getContainerKey(), newTable.length);
            newTable[newPosition] = element;
        }
        table = newTable;
    }
    /**
     * Get position of element by specified key and specified array length.
     * @param key - key.
     * @param size - array size in which contains element with specified key.
     * @return int - позиция элемента.
     */
    private int getPosition(K key, int size) {
        return getHashKey(key.hashCode()) & (size - 1);
    }

    /**
     *Return hash key for key.
     * @param hashCode - hashCode of key.
     * @return int hashKey.
     */
    private int getHashKey(int hashCode) {
        hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
        return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4);
    }

    /**
     * Iterator.
     */

    private int itr = 0;

    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return isContain(itr);
            }

            @Override
            public V next() {
                if (!hasNext())
                    throw new NoSuchElementException();

                return table[itr++].getContainerValue();
            }

            private boolean isContain(int start) {
                boolean result = false;
                while (start < table.length) {
                    if (table[start] != null) {
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

    /**
     * Класс-контейнердля хранения пары ключ-значение.
     * @param <K> - key.
     * @param <V> - value.
     */
    private class Container<K, V> {
        private K contKey;
        private V contValue;

        /**
         * Конструктор контейнера.
         * @param Key - key.
         * @param Value - value.
         */
        Container(K Key, V Value) {
            this.contKey = Key;
            this.contValue = Value;
        }

        /**
         * Get key.
         * @return K - key.
         */
        public K getContainerKey() {
            return contKey;
        }

        /**
         * Get value.
         * @return value.
         */
        public V getContainerValue() {
            return contValue;
        }

        /**
         * Set new value.
         * @param value - new value.
         */
        public void setContainerValue(V value) {
            this.contValue = value;
        }
    }
}