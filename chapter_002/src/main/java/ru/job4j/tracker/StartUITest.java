package ru.job4j.tracker;

/**
 * Created by Kubar on 06.09.2017.
 */
public class StartUITest {
    public static void main(String[] args) {

        Input input = new ConsoleInput();
        new StartUI(input).init();
}}
