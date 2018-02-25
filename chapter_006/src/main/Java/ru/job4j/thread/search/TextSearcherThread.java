package ru.job4j.thread.search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextSearcherThread extends Thread {
    /**
     * Directory visitor.
     */
    private DirectoryVisitor visitor;
    /**
     * Counter for waiting finished all threads.
     */
    private FinishedThreadsCounter count;

    /**
     * TextSearcherThread constructor.
     * @param visitor - directory visitor.
     * @param count - count.
     */
    public TextSearcherThread(DirectoryVisitor visitor, FinishedThreadsCounter count) {
        this.visitor = visitor;
        this.count = count;
    }

    /**
     * Run method.
     */
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " was started for searching " + visitor.getExt() + " files");
            Files.walkFileTree(Paths.get(visitor.getRoot()), visitor);
            System.out.println(Thread.currentThread().getName() + " was finished");
            count.downCount();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}