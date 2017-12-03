package com.bon.service;

import com.bon.model.Checkout;
import com.bon.model.Product;
import com.bon.repository.CheckoutRepository;
import com.bon.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Component
public class CheckoutService {
    private static final Logger log = LoggerFactory.getLogger(CheckoutService.class);

    private CheckoutRepository repository;

    @Autowired
    public CheckoutService(CheckoutRepository repository) {
        if (repository == null) {
            throw new IllegalArgumentException();
        }
        this.repository = repository;
    }

    public Checkout create(Checkout c) {
        log.info("creating checkout: " + c);
        return repository.save(c);
    }
}
