package ru.job4j.thread.lab;

/**
 *
 */
public class SimpleThread implements Runnable {
    private final  int count;

    public SimpleThread(int count) {
        this.count = count;
    }
    @Override
    public void run() {
        System.out.println("Поток " + Thread.currentThread().getName() + " начал работу:");
        for(int i = 0; i < count; i++) {
            System.out.println("- " + Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Поток " + Thread.currentThread().getName() + " закончил работу.");
    }
}
