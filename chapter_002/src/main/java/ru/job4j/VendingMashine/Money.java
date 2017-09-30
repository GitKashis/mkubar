package ru.job4j.VendingMashine;

/**
 * Created by Kubar on 30.09.2017.
 */
public class Money {
    // номинал монет
    private int oneCoin;
    private int twoCoin;
    private int fiveCoin;
    private int tenCoin;

    public int getOneCoin() {
        return oneCoin;
    }

    public void setOneCoin(int oneCoin) {
        this.oneCoin = oneCoin;
    }

    public int getTwoCoin() {
        return twoCoin;
    }

    public void setTwoCoin(int twoCoin) {
        this.twoCoin = twoCoin;
    }

    public int getFiveCoin() {
        return fiveCoin;
    }

    public void setFiveCoin(int fiveCoin) {
        this.fiveCoin = fiveCoin;
    }

    public int getTenCoin() {
        return tenCoin;
    }

    public void setTenCoin(int tenCoin) {
        this.tenCoin = tenCoin;
    }
}
