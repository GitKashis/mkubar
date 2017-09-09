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
    private static String choise = "";
    //меню.
    private String[] menu = {"\n0. Add new Item", "1. Show all items", "2. Edit item", "3. Delete item",
            "4. Find item by Id", "5. Find items by name", "6. Exit Program"};

    //конструктор.
    private StartUI(Input input) {
        this.input = input;
    }

    /**
     *
     */
    private void init() {
        Tracker tracker = new Tracker();

        while (!isExit()) {
            input.print(menu);
            choise = input.ask("Select: ");

            switch (choise) {
                //Add new Item.
                case "0":
                    this.createItem(input, tracker);
                    break;
                //Show all items.
                case "1":
                    input.print(tracker.getAll());
                    break;
                //Edit item.
                case "2":
                    this.updateItem(input, tracker);
                    break;
                //Delete item.
                case "3":
                    tracker.delete(tracker.findById(input.ask("Input Task Id to delete: ")));
                    break;
                //Find item by Id.
                case "4":
                    input.print(tracker.findById(input.ask("Input Task Id: ")));
                    break;
                //Find items by name.
                case "5":
                    input.print(tracker.findByName(input.ask("Input Task name: ")));
                    break;
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
     * Метод создания и добавления заявки в трекер.
     *
     * @param input   - интерфейс ввода.
     * @param tracker - "хранилище" заявок.
     */
    private void createItem(Input input, Tracker tracker) {
        Item item = new Item();
        setItem(input, item);
        tracker.add(item);
    }

    /**
     * Перезапись заявки.
     *
     * @param input   - интерфейс ввода.
     * @param tracker - "хранилище" заявок.
     */
    private void updateItem(Input input, Tracker tracker) {
        //Находим редактируемую заявку по Id.
        Item item = tracker.findById(input.ask("Input Task Id to update: "));
        //Перезаписываем поля записи.
        setItem(input, item);
        //обновляем.
        tracker.update(item);
    }

    /**
     * Метод завершения программы.
     *
     * @return isExit?
     */
    private static boolean isExit() {
        return (choise.equals(EXIT));
    }

    public static void main(String[] args) {
        StartUI stage = new StartUI(new ConsoleInput());
        stage.init();
    }
}
