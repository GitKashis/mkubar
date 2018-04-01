package ru.job4j.optimization;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.Arrays;

public class StartUI {
    /**
     * Start program.
     * @param countOfNumbers - count of numbers.
     */
    public void startProgram(int countOfNumbers) throws TransformerException, ParserConfigurationException {
        Connect connector = new Connect();
        connector.setURL("jdbc:sqlite:src\\main\\java\\ru\\\\job4j\\optimization\\resources\\test.db");
        connector.openConnections();
        connector.initTable();
        connector.setN(countOfNumbers);
        connector.addNumbers();

        int[] numbers = connector.getNumbers();
        ParserToXML parser = new ParserToXML(numbers);
        XMLtoXSL converter = new XMLtoXSL();
        Summator summator = new Summator();

        parser.startParsing();
        converter.convertXML();
        System.out.println(Arrays.toString(numbers));
        System.out.println(summator.getSumm());
        connector.closeConnections();
    }
}
