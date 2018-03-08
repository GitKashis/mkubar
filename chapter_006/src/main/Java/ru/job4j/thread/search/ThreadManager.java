package ru.job4j.thread.search;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadManager {
    /**
     * Root.
     */
    private String root;
    /**
     * Searching text.
     */
    private String text;
    /**
     * Collection of extension.
     */
    private List<String> exts;
    /**
     * Results collection.
     */
    private CopyOnWriteArrayList<String> results;
    /**
     * Counter for finished thread.
     */
    private FinishedThreadsCounter counter = new FinishedThreadsCounter();

    /**
     * ThreadManager constructor.
     * @param root - root.
     * @param exts - extension.
     * @param text - text.
     * @param results - result.
     */
    public ThreadManager(String root, List<String> exts, String text, CopyOnWriteArrayList<String> results) {
        this.root = root;
        this.results = results;
        this.exts = exts;
        this.text = text;
    }

    /**
     * Start text searching.
     */
    public void startSearch() {
        counter.setThreadsCount(exts.size());
        for (String ext : exts) {
            new TextSearcherThread(new DirectoryVisitor(root, ext, text, results), counter).start();
        }

        while (true) {
            if (counter.getThreadsCount() <= 0) {
                break;
            }
        }
    }

}
