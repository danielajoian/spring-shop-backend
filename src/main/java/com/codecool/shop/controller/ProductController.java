package com.codecool.shop.controller;

import com.codecool.shop.model.Product;
import com.codecool.shop.service.ProductStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductStoreService productStoreService;

    @Autowired
    public ProductController(ProductStoreService productStoreService) {
        this.productStoreService = productStoreService;
    }

    @GetMapping("/api")
    public List<Product> getProducts() {
        return productStoreService.getProducts();
    }
}
