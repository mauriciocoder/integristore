package com.bon.repository;

import com.bon.model.Checkout;
import com.bon.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface CheckoutRepository extends CrudRepository<Checkout, Long> {
}