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
        Item item = new Item();

        while (!isExit(choise)) {
            input.print(menu);
            choise = input.ask("Select: ");
            switch (choise) {
                case "0":   item.setName(input.ask("Input Task name: "));
                            item.setDescription(input.ask("Input Task description: "));
                            item.setComment(input.ask("Input Task comment: "));
                            item.setCreate(123);

                            tracker.add(item);
                            break;

                case "1":   input.print(tracker.getAll());
                            break;
                case "2":   item = tracker.findById(input.ask("Input Task Id to update: "));
                            item.setName(input.ask("Input Task name: "));
                            tracker.update(item);
                            break;

                case "3":   item = tracker.findById(input.ask("Input Task Id to delete: "));
                            tracker.delete(item);
                            System.out.println("Item Id " + item.getId() + " is deleted");
                            break;

                case "4":   item = tracker.findById(input.ask("Input Task Id"));
                            input.print(item);
                    break;
                case "5":
                    break;
                case "6":
                    break;
            }
        }
    }
    public void run(){
        input.print(menu);


    }

    private static boolean isExit(String choise){
        return  (choise.equals("6") ? true : false);
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        StartUI stage = new StartUI(input);
        stage.init();
    }
}
