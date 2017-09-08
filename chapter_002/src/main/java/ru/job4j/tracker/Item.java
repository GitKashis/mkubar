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
    private String name;
    // описание.
    private String description;
    // время создания.
    private String create;
    // коментарий.
    private String comment;

    /**
     * конструктор по умолчанию.
     */
    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    /**
     * конструктор с параметрами.
     *
     * @param name        name
     * @param description desc
     */
    public Item(String name, String description, String comment) {
        this.name = name;
        this.description = description;
        this.create = create;
        this.comment = comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getCreate() {
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

    public void setCreate(String create) {
        this.create = create;
    }
}
