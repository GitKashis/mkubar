package ru.job4j.tracker;

public class Item {

    private String Id;
    public String name;
    public String description;
    public long create;
    public Comment comment;

    public Item(){
    }

    public Item(String name, String description, long create){
        this.name = name;
        this.description = description;
        this.create = create;
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

    public void setComment(Comment comment) {
        this.comment = comment;
    }
    public Comment getComment() {
        return this.comment;
    }
}
