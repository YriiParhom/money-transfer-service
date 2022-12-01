package ru.netology.cardtransferback.model;

public class Amount {
    private int value;
    private String currency;

    public Amount(Integer value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }
}
