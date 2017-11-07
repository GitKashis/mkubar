package ru.job4j.vendingMashine;

/**
 * Метод хранит массив заявок items, реализует операции CRUD для объектов типа Cake.
 *
 * @author Mikhail Kubar
 * @version 1.0
 * @since 04.09.17
 */
class Vending {
    // список продуктов.
    private Cake[] cakes = new Cake[10];
    //индекс массива Items[].
    private int position = 0;

    /**
     * Метод создает объект с именем и ценой и добавляет в список продуктов.
     *
     * @param name  - название продукта.
     * @param price - цена.
     * @return Cake cace.
     */
    void add(String name, int price) {
        Cake cace = new Cake(name, price);
        this.cakes[position++] = cace;
    }

    /**
     * Метод расчитывает сдачу, выдаваемую монетами номиналом по 10, 5, 2, 1.
     *
     * @param numOfMenu - номер продукта в списке меню.
     * @param cash      - колиество денег покупателя.
     */
    void buy(int numOfMenu, int cash) {
        int price = this.cakes[numOfMenu].getPrice();

        if (price > cash) System.out.println("Сумма недостаточна!");
        else {
            int toOut = cash - price;
            int toOutTen = 0;
            int toOutFive = 0;
            int toOutTwo = 0;
            int toOutOne = 0;

            System.out.print("Ваша сдача: " + toOut);
            // пока не закончатся десятки.
            while ((Money.getTenCoin() > 0) && (toOut >= 10)) {
                toOut -= 10;
                Money.tenCoinDecrement();
                toOutTen++;
            }
            // пока не закончатся пятерки.
            while ((Money.getFiveCoin() > 0) && (toOut >= 5)) {
                toOut -= 5;
                Money.fiveCoinDecrement();
                toOutFive++;
            }
            // пока не закончатся двойки.
            while ((Money.getTwoCoin() > 0) && (toOut > 1)) {
                toOut -= 2;
                Money.twoCoinDecrement();
                toOutTwo++;
            }
            // пока не закончатся единички.
            while ((Money.getOneCoin() > 0) && (toOut > 0)) {
                toOut--;
                Money.oneCoinDecrement();
                toOutOne++;
            }
            System.out.println(". (десяток: " + toOutTen + ", пятерок: " + toOutFive + ", двоек: " + toOutTwo + ", единичек: " + toOutOne + ")");
        }
    }

    /**
     * Отобразить список продуктов с ценой.
     */
    void showItems() {
        int indexOfMenu = 0;
        for (Cake backe : this.getAll()) {
            System.out.println(String.format("%s. %s. Цена %s.", indexOfMenu++, backe.getName(), backe.getPrice()));
        }
    }

    /**
     * Вспомогательный метод.
     *
     * @return массив без пустых ячеек.
     */
    private Cake[] getAll() {
        Cake result[] = new Cake[position];
        for (int i = 0; i != this.position; i++) {
            if (cakes[i] != null)
                result[i] = this.cakes[i];
        }
        return result;
    }

    /**
     * Вспомогательный метод для возбуждения ошибки MenuOutException.
     *
     * @return
     */
    int[] getCaceRange() {
        return new int[this.getAll().length];
    }
}
