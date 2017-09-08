package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Created by Kubar on 06.09.2017.
 */
public class ConsoleInput implements  Input {

    private Scanner scanner = new Scanner(System.in);

    public String ask(String question){
        System.out.print(question);
        return scanner.next();
    }

    public void print(String[] menu) {
        for(String i : menu)
            System.out.println(i);
    }

    public void print(Item[] items) {
        for(Item item : items )
            print(item);
    }
    public void print(Item item) {
        if (item != null)
            System.out.println("Id: " + item.getId() + "; Name: " + item.getName() + "; Description: " + item.getDescription() +
                "; Create: " + item.getCreate() + "; Comment: " + item.getComment());
    }
}
