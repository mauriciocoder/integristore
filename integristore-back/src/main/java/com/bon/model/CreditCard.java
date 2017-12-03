package com.bon.model;

import javax.persistence.Embeddable;

@Embeddable
public class CreditCard {
    private long cardNumber;
    private String name;
    private int expDateMonth;
    private int expDateYear;

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpDateMonth() {
        return expDateMonth;
    }

    public void setExpDateMonth(int expDateMonth) {
        this.expDateMonth = expDateMonth;
    }

    public int getExpDateYear() {
        return expDateYear;
    }

    public void setExpDateYear(int expDateYear) {
        this.expDateYear = expDateYear;
    }
}
