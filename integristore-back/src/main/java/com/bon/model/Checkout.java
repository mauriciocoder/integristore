package com.bon.model;

import com.bon.config.Action;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

// TODO: Change price for String
@Entity
@Getter
@Setter
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "checkout_id")
    private long id;

    @Embedded
    @NotNull
    private CreditCard creditCard;

    @OneToMany(cascade = CascadeType.MERGE)
    @NotNull
    @JoinTable(name = "checkout_product"
            , joinColumns = { @JoinColumn(name = "checkout_id") }
            , inverseJoinColumns = { @JoinColumn(name = "product_id") })
    private List<Product> products;

    private double cartPrice;

    @AssertTrue(groups = {Action.Update.class, Action.Create.class}, message = "Cart price is not valid")
    private boolean isCartPriceValid() {
        return cartPrice > 0;
    }

    @AssertTrue(groups = {Action.Update.class, Action.Create.class}, message = "Card number is not valid")
    private boolean isCardNumberValid() {
        return creditCard.getCardNumber() > 0;
    }

    @AssertTrue(groups = {Action.Update.class, Action.Create.class}, message = "Card expiration date is not valid")
    private boolean isCardDateValid() {
        return creditCard.getExpDateMonth() > 0
                && creditCard.getExpDateMonth() <= 12
                && creditCard.getExpDateYear() > 16;
    }
}