package ru.job4j.tracker;

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
    private String create;
    // коментарий.
    private String comment;

    //конструктор.
    Item() {
    }
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
        return ("Id: " + this.getId() + "; Name: " + this.getName() + "; Description: " + this.getDescription()
                + "; Create: " + this.getCreate() + "; Comment: " + this.getComment());
    }

    void setName(String name) {
        this.name = name;
    }

    void setDescription(String description) {
        this.description = description;
    }

    String getName() {
        return this.name;
    }

    private String getDescription() {
        return this.description;
    }

    private String getCreate() {
        return this.create;
    }

    String getId() {
        return this.id;
    }

    void setId(String id) {
        this.id = id;
    }

    void setComment(String comment) {
        this.comment = comment;
    }

    String getComment() {
        return this.comment;
    }

    void setCreate(String create) {
        this.create = create;
    }
}
