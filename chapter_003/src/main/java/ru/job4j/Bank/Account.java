package ru.job4j.Bank;

public class Account {
    private int value;
    private String requisites;
    private static int count = 0;

    Account(String requisites) {
        this.value = 0;
        this.requisites = requisites;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    @Override
    public String toString() {
        return "Account = " + value;
    }
}
