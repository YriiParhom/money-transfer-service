package ru.netology.cardtransferback.model;

import java.util.Objects;

public class Card {
    private String cardNumber;
    private String validTill;
    private String CVV;
    private Amount amount;

    public Card(String cardNumber, String validTill, String CVV, Amount amount) {
        this.cardNumber = cardNumber;
        this.validTill = validTill;
        this.CVV = CVV;
        this.amount = amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setValidTill(String validTill) {
        this.validTill = validTill;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getValidTill() {
        return validTill;
    }

    public String getCVV() {
        return CVV;
    }

    public Amount getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardNumber.equals(card.cardNumber) && validTill.equals(card.validTill) && CVV.equals(card.CVV);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, validTill, CVV);
    }
}
