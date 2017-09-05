package ru.job4j.tracker;

import java.util.Random;

public class Tracker {

    private Item[] items = new Item[10];
    private int position = 0;
    private static final Random rn = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }
    public Item add(Comment comment) {

        Item result = this.items[1].setComment(comment);

        return result;
    }

    protected Item findById (String id){
        Item result = null;
        for (Item item: items) {
            if(item != null && item.getId().equals(id))
                result = item;
            break;
        }
        return result;
    }
    protected Item findByName (String id){
        Item result = null;
        for (Item item: items) {
            if(item != null && item.getName().equals(id))
                result = item;
            break;
        }
        return result;
    }


    String generateId() {
        return String.valueOf(rn.nextInt());
    }

    public  Item[] getAll() {
        Item result[] = new Item[position];
        for (int i = 0; i != this.position; i++)
              {
                result[i] = this.items[i];
        }
        return result;
    }
}
