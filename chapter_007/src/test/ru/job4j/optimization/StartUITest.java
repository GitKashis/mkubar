package ru.job4j.optimization;

import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class StartUITest {

    @Test
    public void test() throws TransformerException, ParserConfigurationException {
        StartUI ui = new StartUI();
        long startTime = System.currentTimeMillis();
            ui.startProgram(100);
        long finishTime = System.currentTimeMillis() - startTime;

        System.out.println(String.format("Time: %s ms", finishTime));
    }
}