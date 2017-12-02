package ru.job4j.generic;

import ru.job4j.simplearray.SimpleArray;
/**
 *
 * Created by Kubar on 08.10.2017.
 */
@SuppressWarnings("unchecked")
public class RoleStore  extends AbstractStore<Role> {
    /**
     * Constructor with default RoleStorage size = 5.
     */
    public RoleStore() {
        super(new SimpleArray(5));
    }

    /**
     * Constructor with specified size.
     * @param size - storage size.
     */
    public RoleStore(int size) {
        super(new SimpleArray(size));
    }
}
