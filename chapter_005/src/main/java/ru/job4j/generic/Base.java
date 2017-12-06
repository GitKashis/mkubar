package ru.job4j.generic;

/**
 * todo: comment
 * Created by Kubar on 08.10.2017.
 */
public abstract class Base {

    private String id;

    public Base(String id) {
        this.id = id;
    }

    String getId() {
        return this.id;
    }

    void setId(String id) {
        this.id = id;
    }
}
