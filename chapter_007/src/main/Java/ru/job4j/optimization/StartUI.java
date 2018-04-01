package ru.job4j.optimization;

import java.util.Arrays;

public class StartUI {
    /**
     * Start program.
     * @param countOfNumbers - count of numbers.
     */
    public void startProgram(int countOfNumbers)  {
        Connect connector = new Connect();

        connector.setURL("jdbc:sqlite:src\\\\main\\\\java\\\\\\\\ru\\\\job4j\\\\optimization\\\\resources\\\\test.db");
        connector.openConnections();
        connector.initTable();
        connector.setN(countOfNumbers);
        connector.addNumbers();

        int[] numbers = connector.getNumbers();
        System.out.println(Arrays.toString(numbers));
        connector.closeConnections();
    }
}
