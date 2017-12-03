package com.bon.controller;

import com.bon.config.Action;
import com.bon.model.Checkout;
import com.bon.model.Product;
import com.bon.service.CheckoutService;
import com.bon.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/checkout")
public class CheckoutController {

    private final CheckoutService service;

    @Autowired
    public CheckoutController(CheckoutService service) {
        if (service == null) {
            throw new IllegalArgumentException();
        }
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Creates a new checkout", notes = "Creates a new checkout in database.")
    public ResponseEntity<Void> create(@Validated(Action.Create.class) @RequestBody Checkout checkout) throws URISyntaxException {
        Checkout c = service.create(checkout);
        return ResponseEntity.created(new URI("/checkout/" + c.getId())).build();
    }
}