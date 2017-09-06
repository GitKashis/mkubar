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

}
