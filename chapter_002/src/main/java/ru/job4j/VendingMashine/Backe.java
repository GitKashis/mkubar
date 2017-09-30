package ru.job4j.VendingMashine;

import java.util.HashMap;
import java.util.Map;

public class Backe {
    private  String name;
    private int price;

    Backe(String name, int price) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public String getName() {
        return name;
    }
}