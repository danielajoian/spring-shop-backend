package com.codecool.shop.controller;

import com.codecool.shop.model.Product;
import com.codecool.shop.service.ProductStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/product")
public class ProductController {

    private final ProductStoreService productStoreService;

    @Autowired
    public ProductController(ProductStoreService productStoreService) {
        this.productStoreService = productStoreService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productStoreService.getProducts();
    }

    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable("productId") int productId) {
        return productStoreService.getProductById(productId);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        System.out.println("adaug produs");
        return productStoreService.addProduct(product);
    }
}
