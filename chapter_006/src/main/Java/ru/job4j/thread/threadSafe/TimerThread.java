package ru.job4j.thread.threadSafe;


/**
 *  Класс-таймер следит за работой потока LettersCount. Если заданное время истекает, а подсчет еще ведется,
 *  то поток-таймер прерыавет выполнение LettersCount.
 */
public class TimerThread {
    /**
     * Field object for test interrupted.
     */
    private final LettersCount letters = new LettersCount(
            "A thread is a thread of execution in a program." +
                    "The Java Virtual Machine allows an application to have multiple threads of execution" +
                    "running concurrently. Every thread has a priority. Threads with higher priority" +
                    "are executed in preference to threads with lower priority. " +
                    "Each thread may or may not also be marked as a daemon. " +
                    "When code running in some thread creates a new Thread object, the new thread has its priority" +
                    "initially set equal to the priority of the creating thread, and is a daemon thread if" +
                    " and only if the creating thread is a daemon. When a Java Virtual Machine starts up, " +
                    "there is usually a single non-daemon thread (which typically calls the method named main of " +
                    "some designated class). The Java Virtual Machine continues to execute threads until either" +
                    " of the following occurs: The exit method of class Runtime has been called and " +
                    "the security manager has permitted the exit operation to take place.");

    private final int time;

    public TimerThread(int time) {
        this.time = time;
    }

    /**
     * Method check interrupted.
     * @return true if Thread interrupted
     * @throws InterruptedException if Thread interrupted
     */
    public boolean startCount() throws InterruptedException {
        Thread t1 = new Thread(letters);
        t1.start();
        Thread.currentThread().sleep(this.time);

        if (t1.isAlive()) {
            t1.interrupt();
            System.out.println("Count is interrupted");
        }
        return t1.isInterrupted();
    }
}
