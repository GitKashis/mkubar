package ru.job4j.VendingMashine;

import ru.job4j.tracker.MenuOutException;

import java.util.Scanner;

/**
 * Класс ConsoleInput используется для ввода пользовательских данных из консоли;
 * Расширен от интерфейсного класса Input.
 * {@link ru.job4j.VendingMashine.Input}
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

    /**
     * Перегруженный метод ask проверяет ответ пользователя на наличие пункта в меню.
     *
     * @param question
     * @param range    - длина массива = область значений.
     * @return если выбор верный, возвращает номер действия,
     * если нет - возбуждается ошибка MenuOutException с сообщением msg.
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int i = 0; i <= range.length; i++)
            if (key == i) {
                exist = true;
                break;
            }
        if (exist) return key;
        else throw new MenuOutException("Out of menu range");
    }

    public void print(Object[] objects) {
        for (Object obj : objects) {
            System.out.println(obj);
        }
    }
}
