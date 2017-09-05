package ru.job4j.tracker;

/**
 * Класс описывает сущность "Заявка", является элементом массива items[].
 *
 * @author Mikhail Kubar
 * @version 1.0
 * @since 04.09.17
 */
public class Item {
    // уникальный id, служит для идентивикации записи в массиве.
    private String Id;
    // имя заявки.
    public String name;
    // описание.
    public String description;
    // время создания.
    public long create;
    // коментарий.
    public String comment;


    /**
     * дефолтный конструктор.
     */
    public Item(){
    }

    /**
     * конструктор с параметрами.
     * @param name name
     * @param description desc
     * @param create create
     */
    public Item(String name, String description, long create, String comment){
        this.name = name;
        this.description = description;
        this.create = create;
        this.comment = comment;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public long getCreate() {
        return this.create;
    }

    public String getId() {
        return this.Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return this.comment;
    }
}
