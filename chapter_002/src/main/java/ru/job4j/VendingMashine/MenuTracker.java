package ru.job4j.VendingMashine;

import ru.job4j.tracker.BaseAction;

class MenuTracker {
    private Input input;
    private Tracker tracker;
    private int position = 0;
    private UserAction[] items = new UserAction[7];

    /**
     * Конструктор.
     *
     * @param input   - интерффейс.
     * @param tracker - хранилище объектов-заявок.
     */
    MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
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
        this.items[position++] = new BuyItem();
        this.items[position++] = new ShowItem("Show all items", 1);
        this.items[position++] = new MenuTracker.ExitProgam("Exit Program", 6);
    }

    int[] getLenght() {
        return new int[items.length];
    }

    /**
     * Выбор пользователем действия из списка меню.
     *
     * @param key - значение поля класса, соответствующее расположению
     *            в массиве действий actions[].
     */
    void select(int key) {
        this.items[key].execute(input, tracker);
    }

    /**
     * Вывод форматированной строки, заявленной классом,  в список меню.
     */
    void show() {
        for (UserAction actions : this.actions) {
            if (actions != null) {
                System.out.println(actions.info());
            }
        }
    }

    /**
     * Метод считывает и заносит данные в заявку Backe.
     *
     * @param input - интерфейс ввода.
     * @param backe  - текущая заявка Backe.
     */
    private void setItem(ru.job4j.tracker.Input input, Backe backe) {
        backe.setName(input.ask("Input Task name: "));
        backe.setDescription(input.ask("Input Task description: "));
        backe.setComment(input.ask("Input Task comment: "));
    }

    /**
     * Внутренний класс Add().
     */
    private class AddItem extends BaseAction {
        AddItem(String name, int key) {
            super(name, key);
        }

        public void execute(ru.job4j.tracker.Input input, Tracker tracker) {
            Backe backe = new Backe();
            setItem(input, backe);
            tracker.add(backe);
        }
    }

    /**
     * Внутренний статический класс Show.
     */
    private static class ShowItem extends BaseAction {

        ShowItem(String name, int key) {
            super(name, key);
        }

        public void execute(ru.job4j.tracker.Input input, Tracker tracker) {
            input.print(tracker.getAll());
        }

    }


    /**
     * Внутренний класс Delete.
     */
    private class DeleteItem extends BaseAction {

        DeleteItem(String name, int key) {
            super(name, key);
        }

        public void execute(ru.job4j.tracker.Input input, Tracker tracker) {
            Backe backe = tracker.findById(input.ask("Input Task Id to delete: "));
            tracker.delete(backe);
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
        public void execute(ru.job4j.tracker.Input input, Tracker tracker) {
            System.out.println("Program closes...");
        }
    }
}



