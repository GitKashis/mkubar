package ru.job4j.thread.nonblocking;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

public class Cache<T extends Model> {

    /**
     * Field for orders object.
     */
    private final ConcurrentHashMap<Integer, T> cache = new ConcurrentHashMap<>();

    /**
     * Method add object in Map.
     * @param t object which extend Model abstract class
     * @return Yes or not add in map
     */
    public boolean add(T t) {
        return cache.put(t.getId(), t) == null;
    }

    /**
     * Method delete object of Map.
     * @param t object which extend Model abstract class
     * @return Yes or not if delete object of map
     */
    public boolean delete(T t) {
        return cache.remove(t.getId()) != null;
    }

    /**
     * Method update field name object on the map.
     * @param newT new object
     * @return Yes or not.
     */
    public boolean update(T newT) {
        return cache.computeIfPresent(newT.getId(), new BiFunction<Integer, T, T>() {

            /**
             * Applies this function to the given arguments.
             *
             * @param integer the first function argument
             * @return the function result
             */
            @Override
            public T apply(Integer integer, T oldT) {
                if (newT.getVersion() == oldT.getVersion()) {
                    oldT.setName(newT.getName());
                } else {
                    try {
                        throw new OptimisticException("Incorrect version object!");
                    } catch (OptimisticException e) {
                        e.printStackTrace();
                    }
                }
                return oldT;
            }
        }) != null;
    }
}
