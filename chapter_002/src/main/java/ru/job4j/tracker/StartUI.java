package ru.job4j.tracker;

/**
 * Created by Kubar on 06.09.2017.
 */
public class StartUI {
    private Input input;
    public StartUI(Input input){
        this.input = input;
    }

    public  void init(){
        String name = input.ask("Enter the task name: ");
        Tracker tracker = new Tracker();
        tracker.add(new Item(name, "Description", 1234L, "Comment"));
        for (Item item : tracker.getAll()) {
            System.out.println(item.getName() + "; " + item.getDescription());
        }
    }

    public static void main(String[] args) {

        Input input = new ConsoleInput();
        new StartUI(input).init();
    }

}
