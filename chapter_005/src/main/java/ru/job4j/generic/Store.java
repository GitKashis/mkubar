package ru.job4j.generic;

/**
 * Created by Kubar on 08.10.2017.
 */
public interface Store<T extends Base> {

    T add(T model);

    T update(T model);

    boolean delete(String id);

}
