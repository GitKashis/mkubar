package ru.job4j.thread.search;

import java.util.LinkedList;
import java.util.List;

public class ParallelSearcher {
    /**
     * Results storage.
     */
    private volatile List<String> results = new LinkedList<>();

    /**
     * @param root - search start path.
     * @param text - searching text.
     * @param exts - file extention.
     */
    public void doSearching(String root, String text, List<String> exts) {
        ThreadManager threadManager = new ThreadManager(root, exts, text, results);
        threadManager.startSearch();
    }

    public synchronized List<String> getResults() {
        return results;
    }
}
