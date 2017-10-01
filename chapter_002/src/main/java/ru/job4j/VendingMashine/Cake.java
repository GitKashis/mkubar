package ru.job4j.VendingMashine;

/**
 * Класс 'Плюшка' с названием и ценой.
 */
class Cake {
    private  String name;
    private int price;

    Cake(String name, int price) {
        this.price = price;
        this.name = name;
    }

    int getPrice() {
        return this.price;
    }

    public String getName() {
        return name;
    }
}