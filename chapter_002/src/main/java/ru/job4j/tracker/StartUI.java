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

    //конструктор.
    private StartUI(Input input) {
        this.input = input;
    }

    /**
     *
     */
    private void init() {
        // инициализируем хранение и методы ввода.
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(input, tracker);

        // что будем делать с заявками?
        menu.fillAction();

        // выбираем до тех пор, пока не будет выбрано действие Exit Programm
        // нажатием клавиши '6'.
        String key;

        do {
            menu.show();
            key = input.ask("Select: ");
            menu.select(Integer.valueOf(key));
        }
        while (!key.equals(EXIT));
    }

    public static void main(String[] args) {
        StartUI stage = new StartUI(new ConsoleInput());
        stage.init();
    }
}
