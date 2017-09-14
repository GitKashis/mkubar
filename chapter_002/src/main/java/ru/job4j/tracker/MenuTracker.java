package ru.job4j.tracker;

class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

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
     */
    void fillAction() {
        this.actions[0] = new AddItem();
        this.actions[1] = new MenuTracker.ShowItem();
        this.actions[2] = new UpdateItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();
        this.actions[6] = new MenuTracker.ExitProgam();
    }

    int[] getLenght(){
        return new int[this.actions.length];
    }

    /**
     * Выбор пользователем действия из списка меню.
     *
     * @param key - значение поля класса, соответствующее расположению
     *            в массиве действий actions[].
     */
    void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
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
     * Метод считывает и заносит данные в заявку Item.
     *
     * @param input - интерфейс ввода.
     * @param item  - текущая заявка Item.
     */
    private void setItem(Input input, Item item) {
        item.setName(input.ask("Input Task name: "));
        item.setDescription(input.ask("Input Task description: "));
        item.setComment(input.ask("Input Task comment: "));
    }

    /**
     * Внутренний класс Add().
     */
    private class AddItem implements UserAction {
        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            Item item = new Item();
            setItem(input, item);
            tracker.add(item);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add new Item");
        }
    }

    /**
     * Внутренний статический класс Show.
     */
    private static class ShowItem implements UserAction {
        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            input.print(tracker.getAll());
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }

    /**
     * Внутренний класс Update.
     */
    private class UpdateItem implements UserAction {
        public int key() {
            return 2;
        }

        public void execute(Input input, Tracker tracker) {
            Item editItem = new Item();
            editItem.setId(input.ask("Input Task Id to update: "));
            //Перезаписываем поля записи.
            setItem(input, editItem);
            //обновляем.
            tracker.update(editItem);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Update Item");
        }
    }

    /**
     * Внутренний класс Delete.
     */
    private class DeleteItem implements UserAction {
        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findById(input.ask("Input Task Id to delete: "));
            tracker.delete(item);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Delete item by id");
        }
    }

    /**
     * Внутренний класс FindByName.
     */
    private class FindByName implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findByName(input.ask("Input Task name: "));
            System.out.println(item != null ? "Found " + item : "Not found.");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by name.");
        }
    }

    /**
     * Внутренний статический класс ExitProgam.
     */
    private class ExitProgam implements UserAction {
        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Program closes...");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Exit Program");
        }
    }
}

/**
 * Внешний вложенный класс FindById.
 */
class FindById implements UserAction {
    @Override
    public int key() {
        return 4;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Item item = tracker.findById(input.ask("Input Task Id: "));
        System.out.println(item != null ? "Found " + item : "Not found.");
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Find item by Id");
    }
}


