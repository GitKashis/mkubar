package ru.job4j.thread;

import java.util.StringTokenizer;

/**
 * Класс для подсчета количества слов и пробелов в тексте.
 */
public class Counter {
    /**
     * Text.
     */
    private String text;
    /**
     * count.
     */
    private int spaces = 0;
    private int letters = 0;

    /**
     * Constructor.
     * @param text - text.
     */
    public Counter(String text) {
        this.text = text;
    }

    /**
     * 32 - ascii code of "space"
     * @return space count
     */
    public int getSpaces() {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 32) {
                spaces++;
            }
        }
        return spaces;
    }

    public int getLetters() {
        StringTokenizer ins = new StringTokenizer(text);
        while (ins.hasMoreTokens()) {
            letters++;
        }
        return letters;
    }
}
