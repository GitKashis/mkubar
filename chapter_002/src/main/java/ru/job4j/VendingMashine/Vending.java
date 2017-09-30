package ru.job4j.VendingMashine;

import java.util.HashMap;
import java.util.Map;

/**
 * Метод хранит массив заявок items, реализует операции CRUD для объектов типа Backe.
 *
 * @author Mikhail Kubar
 * @version 1.0
 * @since 04.09.17
 */
class Vending {

    private Backe[] backes = new Backe[5];
    // запас монет.
    private Money money = new Money();
    //индекс массива Items[].
    private int position = 0;

    Vending() {
        this.money.setOneCoin(10);
        this.money.setTwoCoin(10);
        this.money.setFiveCoin(10);
        this.money.setTenCoin(10);

    }

    /**
     * Метод присваивает новой заявке рандомный Id и добавляет в конец массива items.
     *
     * @param item - новая заявка.
     * @return Backe item.
     */
    void add(String name, int price){
        Backe backe = new Backe(name, price);
        this.backes[position++] = backe;
    }

    void buy(int numOfMenu, int cash){
        int price = this.backes[numOfMenu].getPrice();
        int toOut = cash - price;

        if (price > cash) System.out.println("Сумма недостаточна!");

        int toOutTen = toOut % 10;
        int toOutFive = (toOut - toOutTen * 10) % 5;
        int toOutTwo = (toOut - toOutTen * 10 - toOutFive * 5) % 2;
        int toOutOne = toOut - toOutTen * 10 - toOutFive * 5 - toOutTwo * 2;

        System.out.println("Сдача: " + toOut + ", " + toOutTen + ", " + toOutFive + ", " +  toOutTwo + ", " +  toOutOne);
    }

    Backe[] getAll() {
        Backe result[] = new Backe[position];
        for (int i = 0; i != this.position; i++) {
            if (backes[i] != null)
                result[i] = this.backes[i];
        }
        return result;
    }
}
