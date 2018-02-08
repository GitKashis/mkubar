package ru.job4j.thread;

/**
 * Класс, совместно запускающий поток таймера и поток подсчета букв.
 */
public class StartThread {

    private int count;
    private String str = "При работе потоки нередко обращаются к каким-то общим ресурсам, " +
            "которые определены вне потока, например, обращение к какому-то файлу. " +
            "Если одновременно несколько потоков обратятся к общему ресурсу, " +
            "то результаты выполнения программы могут быть неожиданными и даже непредсказуемыми.";

    public StartThread(int count) {
        this.count = count;
    }
    public void init() throws InterruptedException {
        Thread t1 = new Thread(new ThreadTimer(count));
        Thread t2 = new Thread(new LettersCount(str));
        t2.setDaemon(true);
        t1.start();
        t2.start();

        Thread.currentThread().sleep(count);
        if (!t2.isInterrupted()) {
            t2.interrupt();
        }
    }
}
