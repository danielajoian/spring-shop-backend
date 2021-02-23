package com.codecool.shop.controller;

import com.codecool.shop.model.Product;
import com.codecool.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable("productId") long productId) {
        return productService.getProductById(productId);
    }

    @PostMapping
    public Product addProduct(@RequestBody @Valid Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody @Valid Product product, @PathVariable("id") long id) {
        return productService.updateProduct(product, id);
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") long id) {
        return productService.deleteProduct(id);
    }

}
