package ru.job4j.thread.threadSafe;


import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Это блокирующая очередь, ограниченная по размеру.
 * В данном шаблоне Producer помещает данные в очередь, а Consumer извлекает данные из очереди.
 * Если очередь заполнена полностью, то при попытке добавления поток Producer блокируется до тех пор,
 * пока Consumer не извлечет очередные данные, т.е. в очереди появится свободное место.
 * И наоборот если очередь пуста поток Consumer блокируется, до тех пор пока Producer не поместит в очередь данные.
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();
    private int limit;

    public SimpleBlockingQueue(int limit) {
        this.limit = limit;
    }

    /**
     * Метод добавляет элемент в конец очереди.
     *
     * @param value - item.
     * @return true / false.
     */
    public synchronized boolean offer(T value) throws InterruptedException {
        System.out.println("[BlockingQueue]: try to put: " + value );
        while (this.queue.size() == this.limit) {
            System.out.println("[BlockingQueue]: queue is full, waiting");
            this.wait();
        }
        if (this.queue.size() < this.limit) {
            System.out.println("[BlockingQueue]: there was a place, notify");
            this.notifyAll();
        }

        return this.queue.offer(value);
    }

    /**
     * Извлечение элемента из начала  очереди.
     * Если очередь пуста, поток становится вожидание.
     * Если заполнена, то извлекаем элемент и говорим потокам, что есть свободное место.
     *
     * @return T item.
     */
    public synchronized T pool() throws InterruptedException {
        System.out.println("[BlockingQueue]: try to take");
        while (this.queue.size() == 0){
            System.out.println("[BlockingQueue]: queue is empty, waiting until a put");
            this.wait();
        }

        if (this.queue.size() != 0) {
            System.out.println("[BlockingQueue]: there are items in the queue, notify");
            this.notifyAll();
        }

        T item = this.queue.remove();
        System.out.println("[BlockingQueue]: take ok: " + item );
        return item;
    }
}
