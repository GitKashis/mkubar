package ru.job4j.VendingMashine;

import java.util.Map;

class MenuTracker {
    private Input input;
    private Vending vending;
    private int position = 0;
    private UserAction[] actions = new UserAction[7];

    /**
     * Конструктор.
     *  @param input   - интерффейс.
     * @param tracker - хранилище объектов-заявок.
     */
    MenuTracker(Input input, Vending vending) {
        this.input = input;
        this.vending = vending;


    }
    void fillBacke(){
        this.vending.add("Плюшка", 35);
        this.vending.add("Супер Плюшка", 45);
        this.vending.add("Мега Плюшка", 70);
    }
    /**
     * Метод назначает для интерфейсу соответствующий объект.
     * т.к. для разных объектов интерфейс одинаков, то все эти объекты
     * будут содержать методы key(), execute(), show().
     *
     * Название операции и её ключ перенесены в конструктор,
     * реализованы в общем абстрактном классе BaseAction.
     */
    void fillAction() {
        this.actions[position++] = new BuyBacke("", 0);
        this.actions[position++] = new BuyBacke("", 1);
        this.actions[position++] = new BuyBacke("", 2);

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

    void showItems() {
        int indexOfMenu = 0;
        for(Backe backe : vending.getAll()){
            System.out.println(String.format("%s. %s. Цена %s.", indexOfMenu++, backe.getName(), backe.getPrice()));
        }
    }


    /**
     * Внутренний класс().
     */
    private class BuyBacke extends BaseAction {
        BuyBacke(String name, int key) {
            super(name, key);
        }

        public void execute(Input input, Vending vending) {
        vending.buy(2, Integer.valueOf(input.ask("Сколько дадите денег?")));
        }
    }


    int[] getLenght() {
        return new int[this.actions.length];
    }
}



