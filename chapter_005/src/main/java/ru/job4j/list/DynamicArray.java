package ru.job4j.list;

import java.util.Iterator;

/**
 * Динамический список на базе статического массива.
 * Имеет возможность добавления, считывания элементов.
 * Реализована итерация элементов.
 * Масштабируется в обе стороны.
 *
 * Created by Kubar on 08.10.2017.
 */
@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {

    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;
    private int itr = 0;

    /*
    * Добавляет новый элемент в список. При достижении размера внутреннего
    * массива происходит его увеличение в два раза.
    */
    public void add(T item) {
        if(pointer == array.length-1)
            resize(array.length*2); // увеличу в 2 раза, если достигли границ
        array[pointer++] = item;
    }

    /*
    * Возвращает элемент списка по индексу.
    */
    public T get(int index) {
        return (T) array[index];
    }

    /*
    * Удаляет элемент списка по индексу. Все элементы справа от удаляемого
    * перемещаются на шаг налево. Если после удаления элемента количество
    * элементов стало в CUT_RATE раз меньше чем размер внутреннего массива,
    * то внутренний массив уменьшается в два раза, для экономии занимаемого
    * места.
    */
    public void remove(int index) {
        System.arraycopy(array, index + 1, array, index, pointer - index);
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length/2);
        // если элементов в CUT_RATE раз меньше чем
        // длина массива, то уменьшу в два раза
    }
   /*
    * Возвращает количество элементов в списке.
    */
    public int size() {
        return pointer;
    }

   /*
    * Вспомогательный метод для масштабирования.
    */
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        Object[] data = this.array;

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return ((T) data[itr] != null)&&(data.length > itr);
            }

            @Override
            public T next() {
                return (T) data[itr++];
            }
        };
    }
}
