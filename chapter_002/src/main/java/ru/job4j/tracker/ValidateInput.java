package ru.job4j.tracker;

/**
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
            catch (MenuOutException moe) {
                System.out.println("Please select key from menu");
            }
            catch (NumberFormatException nfe) {
                System.out.println("Input correct date again");
            }
        }
        while (invalid);
        return value;
    }
}
