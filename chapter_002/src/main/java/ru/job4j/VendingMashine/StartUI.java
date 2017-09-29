package ru.job4j.VendingMashine;

/**
 * Основной класс программы, реализующей торговый автомат.
 *
 * @author Mikhail Kubar
 * @version 1.0
 * @since 09.09.17
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
        Backe backe = new Backe();
        MenuTracker menu = new MenuTracker(input, backe);

        // какой товар хотите выбрать?
        menu.fillAction();

        // выбираем до тех пор, пока не будет выбрано действие Exit Programm
        // нажатием клавиши '6'.
        do {
            menu.show();
            menu.select(input.ask("Select: ", menu.getLenght()));
        }
        while (!EXIT.equals(input.ask("Exit?: ")));
    }
    }


    public static void main(String[] args) {
        // вместо интерфейса ConsoleInput использован ValidateInput, в котором добавлен
        // контроль данных, вводимых пользоваелем.
        StartUI stage = new StartUI(new ConsoleInput());
        stage.init();
    }


}
