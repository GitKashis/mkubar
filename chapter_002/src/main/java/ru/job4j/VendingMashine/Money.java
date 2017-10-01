package ru.job4j.VendingMashine;

/**
 * Created by Kubar on 30.09.2017.
 */
public class Money {
    // номинал монет
    private static int tenCoin = 10;
    private static int fiveCoin = 5;
    private static int twoCoin = 4;
    private static int oneCoin = 50;


    static int getOneCoin() {
        return oneCoin;
    }

    static int getTwoCoin() {
        return twoCoin;
    }

    static int getFiveCoin() {
        return fiveCoin;
    }

    static int getTenCoin() {
        return tenCoin;
    }

    static int tenCoinDecrement(){
        return tenCoin--;
    }
    static int fiveCoinDecrement(){
        return fiveCoin--;
    }
    static int twoCoinDecrement(){
        return twoCoin--;
    }
    static int oneCoinDecrement(){
        return oneCoin--;
    }

    static int AddTenCoin(int ten){
        return tenCoin += ten;
    }
    static int AddFiveCoin(int five){
        return fiveCoin += five;
    }
    static int AddTwoCoin(int two){
        return twoCoin += two;
    }
    static int AddTOneCoin(int one){
        return oneCoin += one;
    }
}
