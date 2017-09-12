package ru.job4j.tracker;

import java.awt.*;

/**
 * Created by Kubar on 12.09.2017.
 */
class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[5];

    MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    void fillAction() {
        this.actions[0] = new AddItem();
        this.actions[1] = new MenuTracker.ShowItem();
        this.actions[2] = new UpdateItem();
        this.actions[3] = new DeleteItem();

    }

    void select(int key){
        this.actions[key].execute(this.input, this.tracker);
    }

    void show() {
        for (UserAction actions : this.actions){
            if(actions != null) {
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
    void setItem(Input input, Item item) {
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

        public void execute(Input input, Tracker tracker){
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
        public void execute(Input input, Tracker tracker){
            for(Item item : tracker.getAll()) {
                System.out.println(item);
            }
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }

    /**
     * Внутренний статический класс Delete.
     */
    private class DeleteItem implements UserAction {
        public int key() {
            return 3;
        }
        public void execute(Input input, Tracker tracker){
            Item item = tracker.findById(input.ask("Input Task Id to delete: "));
            tracker.delete(item);
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item by id");
        }
    }

}

    class UpdateItem implements UserAction {
    public int key() {
        return 2;
    }
    public void execute(Input input, Tracker tracker){
        Item editItem = new Item();
        editItem.setId(input.ask("Input Task Id to update: "));

        //Перезаписываем поля записи.
        MenuTracker menu = new MenuTracker(input, tracker);
        menu.setItem(input, editItem);
        //обновляем.
        tracker.update(editItem);
    }
    public String info() {
        return String.format("%s. %s", this.key(), "Update Item");
    }
}

