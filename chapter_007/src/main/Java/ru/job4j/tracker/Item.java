package ru.job4j.tracker;

import java.util.Date;

/**
 * Класс описывает сущность "Заявка", является элементом массива items[].
 *
 * @author Mikhail Kubar
 * @version 1.0
 * @since 04.09.17
 */
class Item {
    // уникальный id, служит для идентивикации записи в массиве.
    private String id;
    // имя заявки.
    private String name;
    // описание.
    private String description;
    // время создания.
    private Date create;
    // коментарий.
    private String comment;

    /**
     * конструктор с параметрами.
     *
     * @param name        name
     * @param description desc
     * @param comment comment
     * @value create is Date
     */

    Item(String name, String description, String comment) {
        this.name = name;
        this.description = description;
        this.comment = comment;
    }

    /**
     * Override toString.
     * @return String
     */
    public String toString() {
        return ("Id: " + this.getId() + "; Name: " + this.getName() + "; Description: " + this.getDesc()
                + "; Create: " + this.getDate() + "; Comment: " + this.getCommit());
    }

    void setName(String name) {
        this.name = name;
    }

    void setDesc(String description) {
        this.description = description;
    }

    String getName() {
        return this.name;
    }

    String getDesc() {
        return this.description;
    }

    Date getDate() {
        return this.create;
    }

    String getId() {
        return this.id;
    }

    void setId(String id) {
        this.id = id;
    }

    void setCommit(String comment) {
        this.comment = comment;
    }

    String getCommit() {
        return this.comment;
    }

    void setDate(Date create) {
        this.create = create;
    }
}
