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
        for(int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
    }

    public void print(Item[] items) {
        for(Item item : items )
            System.out.println("Id: " + item.getId() + "; Name: " + item.getName() + "; Description: " + item.getDescription() +
                    "; Create: " + item.getCreate() + "; Comment: " + item.getComment());
    }
    public void print(Item item) {
        System.out.println("Id: " + item.getId() + "; Name: " + item.getName() + "; Description: " + item.getDescription() +
                "; Create: " + item.getCreate() + "; Comment: " + item.getComment());
    }
}
