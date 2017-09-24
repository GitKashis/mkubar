package ru.job4j.tracker;

/**
 * Created by Kubar on 15.09.2017.
 */
public class MenuOutException extends  RuntimeException {

    /**
     * Создать класс MenuOutException должен принимать сообщение об ошибке в конструктор и
     * передавать его в конструктор родителя.
     *
     * @param msg - сообщение.
     */
    public MenuOutException(String msg){
        super(msg);
    }
}
