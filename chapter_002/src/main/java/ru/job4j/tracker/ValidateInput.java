package ru.job4j.tracker;

/**
 * Класс проверяет корректность вводимых пользователем данных при помощи блоков try .. catch.
 * Created by Kubar on 15.09.2017.
 */
class ValidateInput extends ConsoleInput {

    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            }
            // если выбран пункт не в диапазоне меню, то вывод сообщения.
            catch (MenuOutException moe) {
                System.out.println("Please select key from menu");
            }
            // если введено значение, отличное от цифр [0-9]
            catch (NumberFormatException nfe) {
                System.out.println("Input correct date again");
            }
        }
        while (invalid);
        return value;
    }
}
