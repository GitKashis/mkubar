package ru.job4j.optimization;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Summator {
    /**
     * Return summ.
     * @return long.
     */
    public long getSumm() {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        long summ = 0;
        try {
            SAXParser saxParser = parserFactory.newSAXParser();
            Handler handler = new Handler();

            saxParser.parse("src\\main\\java\\ru\\job4j\\optimization\\resources\\2.xml", handler);
            summ = handler.getSum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return summ;
    }
}
