package ru.job4j.VendingMashine;

public class ChargeMetod {
    /**
     * метод возвращает сдачу монетами по 1, 2, 5, 10.
     * @param price - цена покупки.
     * @param value - сумма.
     * @return количество монет.
     */
    int[] charge (int price, int value){
        /*
         * @return в виде массива, где индексу соответствует номинал монет:
         * 3 - единички.
         * 2 - двоечки.
         * 1 - пятерки.
         * 0 - десятки.
         */
        int[] result = new int[4];
        //номиналы монетж
        int[] nominalCoin = new int[]{10, 5, 2, 1};
        // текущее количество монет
        int[] countCoin = new int[]{5, 5, 5, 5};
        // размер сдачи.
        int toOut = value - price;

        // выдаем сначала крупные (из тех, что есть)
        for (int i = 0; i < result.length; i++) {
            // пока остается сдача и есть монеты
            while ((toOut >= nominalCoin[i])&&(countCoin[i] > 0)) {
                // выдаем монетку номиналом i.
                result[i] += 1;
                countCoin[i] -= 1;
                toOut -= nominalCoin[i];

            }
        }
        return result;
    }
}
