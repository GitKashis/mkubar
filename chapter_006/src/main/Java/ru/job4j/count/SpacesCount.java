package ru.job4j.count;

public class SpacesCount implements Runnable {

    /**
     * Text.
     */
    private String text;
    /**
     * spaces count.
     */
    private int spaces = 0;

    /**
     * Constructor.
     * @param text - text.
     */
    public SpacesCount (String text) {
        this.text = text;
    }

    /**
     * Run method for start thread.
     */
    @Override
    public void run() {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 32) {
                spaces++;
            }
        }
        System.out.println(String.format("Count of spaces - %s", spaces));
    }
}
