package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Класс ConsoleInput используется для ввода пользовательских данных из консоли;
 * Расширен от интерфейсного класса Input.
 * {@link ru.job4j.tracker.Input}
 */
public class ConsoleInput implements Input {
    //считывание ввода.
    private Scanner scanner = new Scanner(System.in);

    /**
     * Диалог с пользователем.
     *
     * @param question - вопрос.
     * @return ввод от позьзователя.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.next();
    }

    /**
     * Печать меню на экран.
     *
     * @param menu - список действий.
     */
    public void print(String[] menu) {
        for (String i : menu) {
            System.out.println(i);
        }
    }

    /**
     * Вывод на экран всех текущих заявок.
     *
     * @param items - массив заявок.
     */
    public void print(Item[] items) {
        for (Item item : items) {
            print(item);
        }
    }

    /**
     * Печать одной заявки.
     *
     * @param item - заявка для вывода на экран.
     */
    public void print(Item item) {
        if (item != null) {
            System.out.println("Id: " + item.getId() + "; Name: " + item.getName() + "; Description: " + item.getDescription()
                    + "; Create: " + item.getCreate() + "; Comment: " + item.getComment());
        }
    }
}
