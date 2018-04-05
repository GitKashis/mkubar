package ru.job4j.tracker.item;

import java.util.Date;
import java.util.Random;

/**
 * Класс описывает сущность "Заявка", является элементом массива items[].
 *
 * @author Mikhail Kubar
 * @version 1.0
 * @since 04.09.17
 */
public class Item {
    /**
     * Поле имя.
     */
    private String name;
    /**
     * Поле описание.
     */
    private String description;
    /**
     * Поле дата.
     */
    private Date date;
    /**
     * Поле комминтарий.
     */
    private String commit;
    /**
     * Поле ID.
     */
    private String id;
    private static final Random rn = new Random();

    public Item() {
        this.id = String.valueOf(rn.nextInt(100));
    }

    /**
     * Set name.
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Set description.
     * @param desc description
     */
    public void setDescription(String desc) {
        this.description = desc;
    }
    /**
     * Set data.
     * @param fdate - date of creating item
     */
    public void setDate(Date fdate) {
        this.date = new Date();
    }
    /**
     * Set commit.
     * @param commit commit
     */
    public void setCommit(String commit) {
        this.commit = commit;
    }
    /**
     * Метод получения имяни.
     * @return get name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Метод получения описания.
     * @return get description
     */
    public String getDesc() {
        return this.description;
    }

    /**
     * Метод получения даты.
     * @return get Data
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Получение поля.
     * @return get commit
     */
    public String getCommit() {
        return this.commit;
    }

    /**
     * Method get Id.
     * @return ID
     */
    public String getId() {
        return this.id;
    }

    /**
     * Установка ID.
     * @param id уникальный
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Item{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", date=" + date + ", commit='" + commit + '\'' + ", id='" + id + '\'' + '}';
    }
}