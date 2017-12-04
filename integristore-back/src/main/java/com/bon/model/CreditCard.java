package com.bon.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class CreditCard {
    private long cardNumber;
    private String name;
    private int expDateMonth;
    private int expDateYear;
}
