package ru.job4j.thread.threadSafe;

public class LettersCount implements Runnable {
    /**
     * Text.
     */
    private String text;
    /**
     * Count of letters.
     */
    private int letters = 0;

    /**
     * Constructor.
     * @param text - text.
     */
    public LettersCount(String text) {
        this.text = text;
    }

    /**
     * Run method for start threading.
     */
    @Override
    public void run() {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != 32) {
                letters++;
                System.out.println(String.format("Count of letters - %s", letters));
            }
        }

    }
}
