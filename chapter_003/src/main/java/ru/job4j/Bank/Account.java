package ru.job4j.Bank;

/**
 * это банковский счёт.
 */
class Account {
    private int value;
    private String requisites;

    Account(String requisites) {
        this.value = 100;
        this.requisites = requisites;
    }

    int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return requisites + " = " + value;
    }
}
