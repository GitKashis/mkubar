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

    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for(int i = 0; i <= range.length; i++)
            if(key == i) {
                exist = true;
                break;
            }
            if (exist) return  key;
                else throw new MenuOutException("Out of menu range");
    }

    public void print(Object[] objects) {
        for(Object obj : objects) {
                System.out.println(obj);
        }
    }
}
