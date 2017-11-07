package ru.job4j.vendingMashine;

import static ru.job4j.vendingMashine.Money.*;

/**
 * Класс для работы с меню.
 */
class MenuTracker {
    private Input input;
    private Vending vending;
    private int position = 0;
    private UserAction[] actions = new UserAction[3];

    /**
     * Конструктор.
     *
     * @param input   - интерффейс.
     * @param vending - хранилище объектов-плюшек.
     */
    MenuTracker(Input input, Vending vending) {
        this.input = input;
        this.vending = vending;
    }

    void fillCake() {
        this.vending.add("Плюшка", 35);
        this.vending.add("Супер Плюшка", 45);
        this.vending.add("Мега Плюшка", 70);
    }

    /**
     * Метод назначает для интерфейсу соответствующий объект.
     * т.к. для разных объектов интерфейс одинаков, то все эти объекты
     * будут содержать методы key(), execute(), show().
     * <p>
     * Название операции и её ключ перенесены в конструктор,
     * реализованы в общем абстрактном классе BaseAction.
     */
    void fillAction() {
        this.actions[position++] = new BuyCake("Купить плюшку", 0);
        this.actions[position++] = new AddCoin("Добавить монет", 1);
        this.actions[position++] = new ExitProgam("Exit Program", 2);
    }

    /**
     * Отобразить текущее количество монет.
     */
    void showMoney() {
        System.out.println(String.format("%s. %s. %s. %s.",
                getTenCoin(), getFiveCoin(), getTwoCoin(), getOneCoin()));
    }

    /**
     * Выбор пользователем действия из списка меню.
     *
     * @param key - значение поля класса, соответствующее расположению
     *            в массиве действий actions[].
     */
    void select(int key) {
        this.actions[key].execute(input, this.vending);
    }

    /**
     * Вывод строки, заявленной классом,  в список меню.
     */
    void show() {
        for (UserAction actions : this.actions) {
            if (actions != null) {
                System.out.println(actions.info());
            }
        }
    }

    /**
     * Внутренний класс().
     */
    private class BuyCake extends BaseAction {
        BuyCake(String name, int key) {
            super(name, key);
        }

        public void execute(Input input, Vending vending) {
            vending.showItems();
            int choise = (input.ask("Что желаете? ", vending.getCaceRange()));
            vending.buy(choise, Integer.valueOf(input.ask("Введите сумму: ")));
        }
    }


    int[] getLenght() {
        return new int[this.actions.length];
    }

    private class AddCoin extends BaseAction {
        AddCoin(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Vending vending) {
            int[] rangeOfCoin = new int[100];
            try {
                AddTenCoin(input.ask("Добавить монет по десять: ", rangeOfCoin));
                AddFiveCoin(input.ask("Добавить монет по пять: ", rangeOfCoin));
                AddTwoCoin(input.ask("Добавить монет по два: ", rangeOfCoin));
                AddTOneCoin(input.ask("Добавить монет по одному: ", rangeOfCoin));
            } catch (CoinRangeException moe) {
                throw new CoinRangeException("Money");
            }
        }
    }

    /**
     * Внутренний статический класс ExitProgam.
     */
    private class ExitProgam extends BaseAction {
        ExitProgam(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Vending vending) {
            System.out.println("Program is closing...");
            System.exit(0);
        }
    }
}



