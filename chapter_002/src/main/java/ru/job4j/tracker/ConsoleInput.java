package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Класс ConsoleInput используется для ввода пользовательских данных из консоли;
 * Расширен от интерфейсного класса Input.
 * {@link ru.job4j.tracker.Input}
 */
class ConsoleInput implements Input {
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

    public void print(Object[] objects) {
        for(Object obj : objects) {
            if (obj != null) {
                System.out.println(obj.toString());
            }
        }
    }
}
