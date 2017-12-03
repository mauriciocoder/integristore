package com.bon.service;

import com.bon.model.Product;
import com.bon.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        if (repository == null) {
            throw new IllegalArgumentException();
        }
        this.repository = repository;
    }

    public List<Product> findAll() {
        log.info("finding all products");
        List<Product> all = (List<Product>) repository.findAll();
        if (CollectionUtils.isEmpty(all)) {
            log.info("database is empty");
            throw new ResourceNotFoundException(null, null);
        }
        return all;
    }
}
