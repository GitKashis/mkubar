package ru.job4j.VendingMashine;

public class Charge {

    /**
     * Метод возвращает массив монет по 10, 5, 2, 1 рубль.
     * @param value - уплачиваемая сумма.
     * @param price - цена покупки.
     * @return - сдача int[]. Каждому индексу массива соответствует номинал монеты:
     *              result [0] - единички.
     *              result [1] - двойки.
     *              result [2] - пятерки.
     *              result [3] - десятки.
     */
    public int[] charge(int value, int price){

        int[] result = new int[4];
        int res = value - price;

        // пока не закончатся десятки.
        while ((Money.getTenCoin() > 0) && (res >= 10)) {
            res -= 10;
            Money.tenCoinDecrement();
            result[3] += 1;
        }
        // пока не закончатся пятерки.
        while ((Money.getFiveCoin() > 0) && (res >= 5)) {
            res -= 5;
            Money.fiveCoinDecrement();
            result[2] += 1;
        }
        // пока не закончатся двойки.
        while ((Money.getTwoCoin() > 0) && (res > 1)) {
            res -= 2;
            Money.twoCoinDecrement();
            result[1] += 1;
        }
        // пока не закончатся единички.
        while ((Money.getOneCoin() > 0) && (res > 0)) {
            res--;
            Money.oneCoinDecrement();
            result[0] += 1;
        }
        return result;
    }
}
