package ru.job4j.tracker;

/**
 * Created by Kubar on 06.09.2017.
 */
public class StartUI {
    private Input input;
    private Item item;
    private String choise = "";
    private String[] menu = {"\n0. Add new Item", "1. Show all items", "2. Edit item", "3. Delete item",
            "4. Find item by Id", "5. Find items by name", "6. Exit Program"};

    public StartUI(Input input){
        this.input = input;
    }

    public  void init(){
        Tracker tracker = new Tracker();

        while (!isExit(choise)) {
            input.print(menu);
            choise = input.ask("Select: ");

            switch (choise) {

                case "0":   this.createItem(input, tracker);
                            break;

                case "1":   input.print(tracker.getAll());
                            break;

                case "2":   this.updateItem (input, tracker);
                            break;

                case "3":   tracker.delete(tracker.findById(input.ask("Input Task Id to delete: ")));
                            break;

                case "4":   input.print(tracker.findById(input.ask("Input Task Id: ")));
                            break;

                case "5":   input.print(tracker.findByName(input.ask("Input Task name: ")));
                            break;
            }
        }
    }
    public void setItem(Input input, Item item){
        item.setName(input.ask("Input Task name: "));
        item.setDescription(input.ask("Input Task description: "));
        item.setComment(input.ask("Input Task comment: "));
    }

    public void createItem(Input input, Tracker tracker){
        Item item = new Item();
        setItem(input, item);
        tracker.add(item);
    }

    public void updateItem (Input input, Tracker tracker){
        item = tracker.findById(input.ask("Input Task Id to update: "));
        setItem(input, item);
        tracker.update(item);
    }

    private static boolean isExit(String choise){
        return  (choise.equals("6") ? true : false);
    }

    public static void main(String[] args) {

        StartUI stage = new StartUI(new ConsoleInput());
        stage.init();
    }
}
