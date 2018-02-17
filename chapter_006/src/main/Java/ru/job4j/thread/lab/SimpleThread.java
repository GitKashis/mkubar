package ru.job4j.thread.lab;

/**
 * Класс, выполняющий вывод текстовой строки заданное количество раз
 * и с установленным периодом.
 */
public class SimpleThread implements Runnable {

        /**
         * Количество циклов работы программы
         */
    private int value = 20;

    /**
     * Время блокировки потока
     */
    private int period;

    /**
     * Конструктор
     */
    public SimpleThread(int period) {
        this.period = period;
    }
    @Override
    public void run() {
        System.out.println(String.format("Поток %s начал работу:",  Thread.currentThread().getName()));

        for(int count = 1; count <= value; count++) {
            System.out.println(String.format("- %s, (%s)", Thread.currentThread().getName(), count));
            try {
                Thread.currentThread().sleep(this.period);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Поток " + Thread.currentThread().getName() + " закончил работу.");
    }
}
