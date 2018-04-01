package ru.job4j.optimization;

import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class StartUITest {

    @Test
    public void test() throws TransformerException, ParserConfigurationException {
        StartUI ui = new StartUI();
        ui.startProgram(100);
    }
}