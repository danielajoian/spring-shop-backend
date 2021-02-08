package com.codecool.shop.dao;

import com.codecool.shop.model.Product;
import com.codecool.shop.service.ProductStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    private final ProductStoreService productStoreService;

    @Autowired
    public ProductDao(ProductStoreService productStoreService) {
        this.productStoreService = productStoreService;
    }

    public List<Product> getProducts() {
        return productStoreService.getProducts();
    }
}
