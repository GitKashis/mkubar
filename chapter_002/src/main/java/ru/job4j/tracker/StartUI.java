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
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DEL = "3";
    private static final String FIND_ID = "4";
    private static final String FIND_NAME = "5";
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

        while (!choise.equals(EXIT)) {
            input.print(menu);
            choise = input.ask("Select: ");

            switch (choise) {
                //Add new Item.
                case ADD:
                    this.createItem(input, tracker);
                    break;
                //Show all items.
                case SHOW:
                    input.print(tracker.getAll());
                    break;
                //Edit item.
                case EDIT:
                    this.updateItem(input, tracker);
                    break;
                //Delete item.
                case DEL:
                    tracker.delete(tracker.findById(input.ask("Input Task Id to delete: ")));
                    break;
                //Find item by Id.
                case FIND_ID:
                    System.out.println(tracker.findById(input.ask("Input Task Id: ")));
                    break;
                //Find items by name.
                case FIND_NAME:
                    System.out.println(tracker.findByName(input.ask("Input Task name: ")));
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
        this.setItem(input, item);
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
        this.setItem(input, item);
        //обновляем.
        tracker.update(item);
    }


    public static void main(String[] args) {
        StartUI stage = new StartUI(new ConsoleInput());
        stage.init();
    }
}
