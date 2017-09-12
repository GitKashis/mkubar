package ru.job4j.tracker;

/**
 * Класс StartUi точка входа в программу.
 * Обеспечивает полноценную работу всего приложения (трекера);
 *
 * @author Mikhail Kubar
 * @version 1.0
 * @since 09.09.17
 */
public class StartUI {
    //интерфейс ввода.
    private Input input;
    //ключ завершения цикла.
    private static final String EXIT = "6";
    //выбор пункта меню.
    private static String key = "";
    //конструктор.
    private StartUI(Input input) {
        this.input = input;
    }

    /**
     *
     */
    private void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(input, tracker);
        menu.fillAction();

        while (!key.equals(EXIT)) {
            menu.show();
            key = input.ask("Select: ");
            menu.select(Integer.valueOf(key));

        }
    }

    public static void main(String[] args) {
        StartUI stage = new StartUI(new ConsoleInput());
        stage.init();
    }
}
