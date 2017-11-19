package ru.job4j.iterator;

import java.util.*;

/**
 * todo:
 * Created by Kubar on 08.10.2017.
 */
class IteratorConverter {

    @SafeVarargs
    static Iterator<Integer> iteratorConvert(Iterator<Integer>... iterators) {
        return new Iterator<Integer>() {
            private final Iterator<Iterator<Integer>> iterator;
            // позиция каретки.
            private Iterator<Integer> currentIterator;

            {
                // добавление в коллекцию iteratorList всех элементов массива iterators.
                List<Iterator<Integer>> iteratorList = new ArrayList<>(iterators.length);
                Collections.addAll(iteratorList, iterators);
                iterator = iteratorList.iterator();
            }

            /**
             * Вспомогательный метод для проверки текущей позиции.
             */
            private void check(){
                if (currentIterator == null && iterator.hasNext())
                    currentIterator = iterator.next();
            }

            /**
             * Проверяем, есть ли еще итераторы
             * @return boolean
             */
            @Override
            public boolean hasNext() {
                check();
                if(currentIterator == null)
                    return false;
                if(currentIterator.hasNext())
                    return true;

                if(iterator.hasNext())
                    currentIterator = iterator.next();

                return currentIterator.hasNext();
            }

            /**
             * Возвращает ход итератора.
             * Если итераций массиве нет, то выкидывает ошибку NoSuchElementException.
             * @return Integer
             */
            @Override
            public Integer next() {
                check();
                if(currentIterator == null)
                    throw new NoSuchElementException();

                if(!currentIterator.hasNext() && iterator.hasNext())
                    currentIterator = iterator.next();

                return currentIterator.next();
            }
        };
    }
}
