package ru.job4j.tracker;

/**
 * Created by Kubar on 12.09.2017.
 */
 interface UserAction {
    int key();

    void execute(Input input, Tracker tracker);

    String info();
}
