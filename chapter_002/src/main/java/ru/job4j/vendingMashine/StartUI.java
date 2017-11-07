package ru.job4j.vendingMashine;

/**
 * Основной класс программы, реализующей торговый автомат.
 *
 * @author Mikhail Kubar
 * @version 1.0
 * @since 30.09.17
 */
public class StartUI {
    //интерфейс ввода.
    private Input input;
    //ключ завершения цикла.
    private static final String EXIT = "y";
    //конструктор.
    private StartUI(Input input) {
        this.input = input;
    }

    private void init() {
        // инициализируем хранение и методы ввода.
        Vending vending = new Vending();
        MenuTracker menu = new MenuTracker(input, vending);
        // загружаем список действий и список продуктов.
        menu.fillAction();
        menu.fillCake();

        // выбираем до тех пор, пока не будет выбрано действие Exit Programm.
        do {
            menu.showMoney();
            menu.show();
            menu.select(input.ask("Select: ", menu.getLenght()));
        }
        while (!EXIT.equals(input.ask("Exit (y/n): ")));
    }

    public static void main(String[] args) {
        // вместо интерфейса ConsoleInput использован ValidateInput, в котором добавлен
        // контроль данных, вводимых пользоваелем.
        StartUI stage = new StartUI(new ValidateInput());
        stage.init();
    }


}
