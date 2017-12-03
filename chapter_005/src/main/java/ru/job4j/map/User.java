package ru.job4j.map;

import java.util.Calendar;

/**
 * Class for creating User.
 */
public class User {
    /**
     * User name.
     */
    private String name;
    /**
     * User children.
     */
    private int children;
    /**
     * User birthday.
     */
    private Calendar birthday;

    /**
     * User constructor.
     *
     * @param name     - user name.
     * @param children -  user children.
     * @param birthday - user birthday.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}