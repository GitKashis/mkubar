package ru.job4j.tracker;

/**
 * Базовый абстрактный класс, содержащий конструктор и реализующий общий метод info().
 * Created by Kubar on 24.09.2017.
 */
abstract class BaseAction implements UserAction {
    private String name;
    private int key;

    /**
     * Конструктор с параметрами.
     * @param name - имя операции.
     * @param key - функциональная клавиша.
     */
    BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }


    /**
     * @return значение, переданное в конструктор.
     */
    public int key() {
        return this.key;
    }

    public abstract void execute(Input input, Tracker tracker);

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }
}
