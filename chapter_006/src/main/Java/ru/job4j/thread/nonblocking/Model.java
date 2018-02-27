package ru.job4j.thread.nonblocking;

public abstract class Model {

    /**
     * User name field.
     */
    String name;

    /**
     * ID user.
     */
    int id;

    /**
     * Version refactor.
     */
    volatile int version;

    /**
     * Getter for version object.
     * @return version now
     */
    abstract int getVersion();

    /**
     * Getter for ID field.
     * @return ID user
     */
    abstract public int getId();

    /**
     * Setter for User name.
     * @param name User
     */
    abstract void setName(String name);

    /**
     * Getter for field name.
     * @return name
     */
    abstract String getName();
}
