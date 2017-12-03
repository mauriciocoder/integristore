package com.bon.model;

import javax.persistence.*;
import java.util.List;

// TODO: Add Validation
// TODO: Change price for String
@Entity
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "checkout_id")
    private long id;

    @Embedded
    private CreditCard creditCard;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "checkout_product"
            , joinColumns = { @JoinColumn(name = "checkout_id") }
            , inverseJoinColumns = { @JoinColumn(name = "product_id") })
    private List<Product> products;

    private double cartPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(double cartPrice) {
        this.cartPrice = cartPrice;
    }
}