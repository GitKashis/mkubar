package ru.job4j.tracker;

class MenuTracker {
    private Input input;
    private Tracker tracker;
    private int position = 0;
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
     *
     * Название операции и её ключ перенесены в конструктор,
     * реализованы в общем абстрактном классе BaseAction.
     */
    void fillAction() {
        this.actions[position++] = new AddItem("Add new Item", 0);
        this.actions[position++] = new MenuTracker.ShowItem("Show all items", 1);
        this.actions[position++] = new UpdateItem("Update Backe", 2);
        this.actions[position++] = new DeleteItem("Delete item by id", 3);
        this.actions[position++] = new FindById("Find item by Id", 4);
        this.actions[position++] = new FindByName("Find item by name.", 5);
        this.actions[position++] = new MenuTracker.ExitProgam("Exit Program", 6);
    }

    int[] getLenght() {
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
     * Метод считывает и заносит данные в заявку Backe.
     *
     * @param input - интерфейс ввода.
     * @param item  - текущая заявка Backe.
     */
    private void setItem(Input input, Item item) {
        item.setName(input.ask("Input Task name: "));
        item.setDescription(input.ask("Input Task description: "));
        item.setComment(input.ask("Input Task comment: "));
    }

    /**
     * Внутренний класс Add().
     */
    private class AddItem extends BaseAction {
        AddItem(String name, int key) {
            super(name, key);
        }

        public void execute(Input input, Tracker tracker) {
            Item item = new Item();
            setItem(input, item);
            tracker.add(item);
        }
    }

    /**
     * Внутренний статический класс Show.
     */
    private static class ShowItem extends BaseAction {

        ShowItem(String name, int key) {
            super(name, key);
        }

        public void execute(Input input, Tracker tracker) {
            input.print(tracker.getAll());
        }

    }

    /**
     * Внутренний класс Update.
     */
    private class UpdateItem extends BaseAction {

        UpdateItem(String name, int key) {
            super(name, key);
        }

        public void execute(Input input, Tracker tracker) {
            Item editItem = new Item();
            editItem.setId(input.ask("Input Task Id to update: "));
            //Перезаписываем поля записи.
            setItem(input, editItem);
            //обновляем.
            tracker.update(editItem);
        }
    }

    /**
     * Внутренний класс Delete.
     */
    private class DeleteItem extends BaseAction {

        DeleteItem(String name, int key) {
            super(name, key);
        }

        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findById(input.ask("Input Task Id to delete: "));
            tracker.delete(item);
        }
    }

    /**
     * Внутренний класс FindByName.
     */
    private class FindByName extends BaseAction {
        FindByName(String name, int key) {
            super(name, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findByName(input.ask("Input Task name: "));
            System.out.println(item != null ? "Found " + item : "Not found.");
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
        public void execute(Input input, Tracker tracker) {
            System.out.println("Program closes...");
        }
    }
}

/**
 * Внешний вложенный класс FindById.
 */
class FindById extends BaseAction {

    FindById(String name, int key) {
        super(name, key);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Item item = tracker.findById(input.ask("Input Task Id: "));
        System.out.println(item != null ? "Found " + item : "Not found.");
    }
}


