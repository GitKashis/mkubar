package ru.job4j.thread.search;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Class for testing text searcher.
 */
public class ParallelSearcherTest {
    /**
     * Testing search text.
     * @throws InterruptedException - exception.
     */
    @Test
    public void whenSearchTextThenResultHasFiveLinks() throws InterruptedException {
        List<String> list = new LinkedList<>();
        list.add("java");
        list.add("txt");
        list.add("html");

        ParallelSearcher ps = new ParallelSearcher();
        ps.doSearching("c:\\projects\\mkubar\\chapter_006\\", "qwerty", list);
        List<String> result = ps.getResults();
        System.out.println(result.size());
        result.forEach(s -> System.out.println(s));
    }
}