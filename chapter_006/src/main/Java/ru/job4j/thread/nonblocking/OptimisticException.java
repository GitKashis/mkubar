package ru.job4j.thread.nonblocking;

public class OptimisticException extends Exception {

    /**
     * перед обновлением данных проверить. что текущий пользователь не затер
     * данные другого пользователя. если данные затерты то выбросить OplimisticException
     */
    public OptimisticException(String message) {
        super(message);
    }
}
