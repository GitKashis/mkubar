package ru.job4j.thread.search;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ParallelSearcher {
    /**
     * Results storage.
     */
    private CopyOnWriteArrayList<String> results = new CopyOnWriteArrayList<>();

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
