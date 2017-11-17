package ru.job4j.generic;

import ru.job4j.simplearray.SimpleArray;

/**
 *
 * Created by Kubar on 08.10.2017.
 */
@SuppressWarnings("unchecked")
public class UserStore extends AbstractStore {
    /**
     * Constructor with default UserStorage size = 5.
     */
    public UserStore() {
        super(new SimpleArray(5));
    }

    /**
     * Constructor with specified UserStorage size.
     * @param size - UserStorage size.
     */
    public UserStore(int size) {
        super(new SimpleArray(size));
    }
}
